<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230926/553d3a500b354e2eba5284b118ccdbeb.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"30px 80px 120px","margin":"100px auto 60px","borderRadius":"12px","background":"url(http://codegen.caihongy.cn/20230926/2c5c44ca8f254e66a66e98a9a603782c.png) no-repeat center top / 110% auto,#259b24","clipPath":"polygon(5% 0, 95% 0, 100% 5%, 100% 85%, 50% 100%, 50% 100%, 0 85%, 0 5%)","width":"38vw","position":"relative","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 10px 0","lineHeight":"44px","fontSize":"20px","color":"rgba(64, 158, 255, 1)","textAlign":"center"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0px auto 10px","color":"#fff","textAlign":"center","width":"100%","letterSpacing":"4px","lineHeight":"44px","fontSize":"26px"}'>林业资源管理系统设计与实现注册</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='gongzuorenyuan'" prop="gonghao">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('gonghao')?'required':''">工号：</div>
				<el-input v-model="registerForm.gonghao"  placeholder="请输入工号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='gongzuorenyuan'" prop="mima">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='gongzuorenyuan'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='gongzuorenyuan'" prop="xingming">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('xingming')?'required':''">姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='gongzuorenyuan'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in gongzuorenyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='gongzuorenyuan'" prop="shouji">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('shouji')?'required':''">手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='gongzuorenyuan'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="gongzuorenyuantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shilinyeju'" prop="linyejumingcheng">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('linyejumingcheng')?'required':''">林业局名称：</div>
				<el-input v-model="registerForm.linyejumingcheng"  placeholder="请输入林业局名称" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shilinyeju'" prop="mima">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shilinyeju'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shilinyeju'" prop="fuzeren">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('fuzeren')?'required':''">负责人：</div>
				<el-input v-model="registerForm.fuzeren"  placeholder="请输入负责人" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shilinyeju'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in shilinyejuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shilinyeju'" prop="shouji">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('shouji')?'required':''">手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shilinyeju'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="shilinyejutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='kaifaqiye'" prop="qiyemingcheng">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('qiyemingcheng')?'required':''">企业名称：</div>
				<el-input v-model="registerForm.qiyemingcheng"  placeholder="请输入企业名称" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='kaifaqiye'" prop="mima">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='kaifaqiye'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='kaifaqiye'" prop="fuzeren">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('fuzeren')?'required':''">负责人：</div>
				<el-input v-model="registerForm.fuzeren"  placeholder="请输入负责人" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='kaifaqiye'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in kaifaqiyexingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='kaifaqiye'" prop="shouji">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('shouji')?'required':''">手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='kaifaqiye'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 5px 0 0","color":"#fff","textAlign":"right","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="kaifaqiyetouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","boxShadow":"0px 4px 0px #075c06","margin":"20px 10px 0 10vw","color":"#fff","display":"inline-block","outline":"none","borderRadius":"4px","background":"#09bd09","width":"auto","fontSize":"16px","height":"44px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0px auto 0px","color":"#eee","textAlign":"right","display":"inline-block","outline":"none","borderRadius":"4px","background":"#49c549","width":"auto","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 20px","margin":"20px 0 40px","color":"#eee","textAlign":"right","display":"inline-block","width":"92%","lineHeight":"1","fontSize":"14px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            gongzuorenyuanxingbieOptions: [],
            shilinyejuxingbieOptions: [],
            kaifaqiyexingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='gongzuorenyuan'){
				this.registerForm = {
					gonghao: '',
					mima: '',
					mima2: '',
					xingming: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if(this.tableName=='shilinyeju'){
				this.registerForm = {
					linyejumingcheng: '',
					mima: '',
					mima2: '',
					fuzeren: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if(this.tableName=='kaifaqiye'){
				this.registerForm = {
					qiyemingcheng: '',
					mima: '',
					mima2: '',
					fuzeren: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.requiredRules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.requiredRules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.requiredRules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('gongzuorenyuan' == this.tableName) {
				this.requiredRules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.requiredRules.linyejumingcheng = [{ required: true, message: '请输入林业局名称', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.requiredRules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.requiredRules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('shilinyeju' == this.tableName) {
				this.requiredRules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.requiredRules.qiyemingcheng = [{ required: true, message: '请输入企业名称', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.requiredRules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.requiredRules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('kaifaqiye' == this.tableName) {
				this.requiredRules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('gongzuorenyuan' == this.tableName) {
			this.rules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }];
		  }
		  if ('gongzuorenyuan' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('gongzuorenyuan' == this.tableName) {
			this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
		  }
			this.gongzuorenyuanxingbieOptions = "男,女".split(',');
		  if ('gongzuorenyuan' == this.tableName) {
			this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }];
		  }
		  if ('gongzuorenyuan' == this.tableName) {
			this.rules.shouji = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
		  }
		  if ('shilinyeju' == this.tableName) {
			this.rules.linyejumingcheng = [{ required: true, message: '请输入林业局名称', trigger: 'blur' }];
		  }
		  if ('shilinyeju' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('shilinyeju' == this.tableName) {
			this.rules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }];
		  }
			this.shilinyejuxingbieOptions = "男,女".split(',');
		  if ('shilinyeju' == this.tableName) {
			this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }];
		  }
		  if ('shilinyeju' == this.tableName) {
			this.rules.shouji = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
		  }
		  if ('kaifaqiye' == this.tableName) {
			this.rules.qiyemingcheng = [{ required: true, message: '请输入企业名称', trigger: 'blur' }];
		  }
		  if ('kaifaqiye' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('kaifaqiye' == this.tableName) {
			this.rules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }];
		  }
			this.kaifaqiyexingbieOptions = "男,女".split(',');
		  if ('kaifaqiye' == this.tableName) {
			this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }];
		  }
		  if ('kaifaqiye' == this.tableName) {
			this.rules.shouji = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      gongzuorenyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      shilinyejutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      kaifaqiyetouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.gonghao) && `gongzuorenyuan` == this.tableName){
					this.$message.error(`工号不能为空`);
					return
				}
               if(`gongzuorenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `gongzuorenyuan` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.xingming) && `gongzuorenyuan` == this.tableName){
					this.$message.error(`姓名不能为空`);
					return
				}
				if((!this.registerForm.xingbie) && `gongzuorenyuan` == this.tableName){
					this.$message.error(`性别不能为空`);
					return
				}
				if((!this.registerForm.shouji) && `gongzuorenyuan` == this.tableName){
					this.$message.error(`手机不能为空`);
					return
				}
					if(`gongzuorenyuan` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
				if((!this.registerForm.linyejumingcheng) && `shilinyeju` == this.tableName){
					this.$message.error(`林业局名称不能为空`);
					return
				}
               if(`shilinyeju` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `shilinyeju` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.fuzeren) && `shilinyeju` == this.tableName){
					this.$message.error(`负责人不能为空`);
					return
				}
				if((!this.registerForm.xingbie) && `shilinyeju` == this.tableName){
					this.$message.error(`性别不能为空`);
					return
				}
				if((!this.registerForm.shouji) && `shilinyeju` == this.tableName){
					this.$message.error(`手机不能为空`);
					return
				}
					if(`shilinyeju` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
				if((!this.registerForm.qiyemingcheng) && `kaifaqiye` == this.tableName){
					this.$message.error(`企业名称不能为空`);
					return
				}
               if(`kaifaqiye` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `kaifaqiye` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.fuzeren) && `kaifaqiye` == this.tableName){
					this.$message.error(`负责人不能为空`);
					return
				}
				if((!this.registerForm.xingbie) && `kaifaqiye` == this.tableName){
					this.$message.error(`性别不能为空`);
					return
				}
				if((!this.registerForm.shouji) && `kaifaqiye` == this.tableName){
					this.$message.error(`手机不能为空`);
					return
				}
					if(`kaifaqiye` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230926/553d3a500b354e2eba5284b118ccdbeb.jpg);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
						width: 100%;
						align-items: center;
						flex-wrap: wrap;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 4px;
						padding: 0 10px;
						color: #666;
						background: #fff;
						width: auto;
						font-size: 14px;
						border-color: #1abc9e30;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 300px;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 4px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: #fff;
						width: auto;
						font-size: 14px;
						border-color: #1abc9e30;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 300px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 4px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: auto;
						font-size: 14px;
						border-color: #1abc9e30;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 300px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 4px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: auto;
						font-size: 14px;
						border-color: #1abc9e30;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 300px;
						height: 40px;
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
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  color: #1abc9e80;
		  		  background: #fff;
		  		  width: 150px;
		  		  font-size: 32px;
		  		  border-color: #1abc9e30;
		  		  border-width: 0 0 1px;
		  		  line-height: 60px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  color: #1abc9e80;
		  		  background: #fff;
		  		  width: 150px;
		  		  font-size: 32px;
		  		  border-color: #1abc9e30;
		  		  border-width: 0 0 1px;
		  		  line-height: 60px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  color: #1abc9e80;
		  		  background: #fff;
		  		  width: 150px;
		  		  font-size: 32px;
		  		  border-color: #1abc9e30;
		  		  border-width: 0 0 1px;
		  		  line-height: 60px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 110px;
				position: absolute;
				content: "*";
				order: 2;
			}
</style>
