<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231106/3709d8140ad547f9a323b49846a1a81a.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"1px solid rgba(255,255,255,.6)","padding":"20px 100px 40px","margin":"20px auto","alignItems":"flex-start","textAlign":"center","display":"block","justifyContent":"flex-start","borderRadius":"20px","flexWrap":"wrap","background":"rgba(255,255,255,.9)","width":"500px","position":"relative","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0 0 10px","margin":"0 0 10px","borderColor":"#d8ae86","color":"#333","textAlign":"center","display":"inline-block","background":"none","borderWidth":"0 0 0px","width":"100%","lineHeight":"40px","fontSize":"20px","borderStyle":"solid","fontWeight":"500"}' class="title">林业资源管理系统设计与实现注册</div>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongzuorenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('gonghao')?'required':''">工号：</div>
					<el-input  v-model="ruleForm.gonghao"  autocomplete="off" placeholder="工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongzuorenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongzuorenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongzuorenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongzuorenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in gongzuorenyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongzuorenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongzuorenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="gongzuorenyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='shilinyeju'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('linyejumingcheng')?'required':''">林业局名称：</div>
					<el-input  v-model="ruleForm.linyejumingcheng"  autocomplete="off" placeholder="林业局名称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='shilinyeju'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='shilinyeju'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='shilinyeju'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('fuzeren')?'required':''">负责人：</div>
					<el-input  v-model="ruleForm.fuzeren"  autocomplete="off" placeholder="负责人"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='shilinyeju'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in shilinyejuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='shilinyeju'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='shilinyeju'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="shilinyejutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifaqiye'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('qiyemingcheng')?'required':''">企业名称：</div>
					<el-input  v-model="ruleForm.qiyemingcheng"  autocomplete="off" placeholder="企业名称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifaqiye'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifaqiye'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifaqiye'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('fuzeren')?'required':''">负责人：</div>
					<el-input  v-model="ruleForm.fuzeren"  autocomplete="off" placeholder="负责人"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifaqiye'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in kaifaqiyexingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifaqiye'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 20px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifaqiye'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#333","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="kaifaqiyetouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"1px solid #ddd","cursor":"pointer","padding":"0 24px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 0px 0 0","color":"#1f6f4a","display":"inline-block","letterSpacing":"4px","float":"left","outline":"none","borderRadius":"30px","background":"#fff","width":"250px","fontSize":"16px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","margin":"0px 0 0","color":"#666","textAlign":"right","display":"inline-block","width":"250px","lineHeight":"44px","fontSize":"14px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            gongzuorenyuanxingbieOptions: [],
            shilinyejuxingbieOptions: [],
            kaifaqiyexingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='gongzuorenyuan'){
				this.ruleForm = {
					gonghao: '',
					mima: '',
					xingming: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if(this.tableName=='shilinyeju'){
				this.ruleForm = {
					linyejumingcheng: '',
					mima: '',
					fuzeren: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if(this.tableName=='kaifaqiye'){
				this.ruleForm = {
					qiyemingcheng: '',
					mima: '',
					fuzeren: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.rules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.rules.linyejumingcheng = [{ required: true, message: '请输入林业局名称', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.rules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.rules.qiyemingcheng = [{ required: true, message: '请输入企业名称', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.rules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			this.gongzuorenyuanxingbieOptions = "男,女".split(',')
			this.shilinyejuxingbieOptions = "男,女".split(',')
			this.kaifaqiyexingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        gongzuorenyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        shilinyejutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        kaifaqiyetouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.gonghao) && `gongzuorenyuan` == this.tableName){
						this.$message.error(`工号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `gongzuorenyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `gongzuorenyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `gongzuorenyuan` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					if((!this.ruleForm.xingbie) && `gongzuorenyuan` == this.tableName){
						this.$message.error(`性别不能为空`);
						return
					}
					if((!this.ruleForm.shouji) && `gongzuorenyuan` == this.tableName){
						this.$message.error(`手机不能为空`);
						return
					}
					if(`gongzuorenyuan` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if((!this.ruleForm.linyejumingcheng) && `shilinyeju` == this.tableName){
						this.$message.error(`林业局名称不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `shilinyeju` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `shilinyeju` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.fuzeren) && `shilinyeju` == this.tableName){
						this.$message.error(`负责人不能为空`);
						return
					}
					if((!this.ruleForm.xingbie) && `shilinyeju` == this.tableName){
						this.$message.error(`性别不能为空`);
						return
					}
					if((!this.ruleForm.shouji) && `shilinyeju` == this.tableName){
						this.$message.error(`手机不能为空`);
						return
					}
					if(`shilinyeju` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if((!this.ruleForm.qiyemingcheng) && `kaifaqiye` == this.tableName){
						this.$message.error(`企业名称不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `kaifaqiye` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `kaifaqiye` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.fuzeren) && `kaifaqiye` == this.tableName){
						this.$message.error(`负责人不能为空`);
						return
					}
					if((!this.ruleForm.xingbie) && `kaifaqiye` == this.tableName){
						this.$message.error(`性别不能为空`);
						return
					}
					if((!this.ruleForm.shouji) && `kaifaqiye` == this.tableName){
						this.$message.error(`手机不能为空`);
						return
					}
					if(`kaifaqiye` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20231106/3709d8140ad547f9a323b49846a1a81a.png);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 30px;
						padding: 0 10px;
						color: #666;
						background: none;
						width: 300px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 30px;
						padding: 0 10px;
						color: #666;
						background: none;
						width: 300px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 30px;
						padding: 0 10px 0 30px;
						color: #666;
						background: none;
						width: 300px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 30px;
						padding: 0 10px 0 30px;
						color: #666;
						background: none;
						width: 300px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid #d4d5d6;
		  		  cursor: pointer;
		  		  border-radius: 30px;
		  		  color: #666;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 90px;
		  		  font-size: 18px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #d4d5d6;
		  		  cursor: pointer;
		  		  border-radius: 30px;
		  		  color: #666;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 90px;
		  		  font-size: 18px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #d4d5d6;
		  		  cursor: pointer;
		  		  border-radius: 30px;
		  		  color: #666;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 90px;
		  		  font-size: 18px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 3px;
				content: "*";
				order: 3;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
