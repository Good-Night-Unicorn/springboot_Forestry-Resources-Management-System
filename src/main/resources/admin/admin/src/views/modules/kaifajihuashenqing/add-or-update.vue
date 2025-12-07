<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","fontSize":"14px","color":"#666","background":"#e5e6e6"}'>
		<el-form
			:style='{"padding":"30px 30px 20px","borderColor":"#355749","borderRadius":"4px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,1)","borderWidth":"2px 0 0","display":"block","fontSize":"inherit","borderStyle":"solid"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="林地名称" prop="lindimingcheng">
					<el-input v-model="ruleForm.lindimingcheng" placeholder="林地名称" clearable  :readonly="ro.lindimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="林地名称" prop="lindimingcheng">
					<el-input v-model="ruleForm.lindimingcheng" placeholder="林地名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="林地类型" prop="lindileixing">
					<el-input v-model="ruleForm.lindileixing" placeholder="林地类型" clearable  :readonly="ro.lindileixing"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="林地类型" prop="lindileixing">
					<el-input v-model="ruleForm.lindileixing" placeholder="林地类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="区域" prop="quyu">
					<el-input v-model="ruleForm.quyu" placeholder="区域" clearable  :readonly="ro.quyu"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="区域" prop="quyu">
					<el-input v-model="ruleForm.quyu" placeholder="区域" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="林地面积" prop="lindimianji">
					<el-input v-model="ruleForm.lindimianji" placeholder="林地面积" clearable  :readonly="ro.lindimianji"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="林地面积" prop="lindimianji">
					<el-input v-model="ruleForm.lindimianji" placeholder="林地面积" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="upload" v-if="type!='info' && !ro.linditupian" label="林地图片" prop="linditupian">
					<file-upload
						tip="点击上传林地图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.linditupian?ruleForm.linditupian:''"
						@change="linditupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="upload" v-else-if="ruleForm.linditupian" label="林地图片" prop="linditupian">
					<img v-if="ruleForm.linditupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.linditupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.linditupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="date" v-if="type!='info'" label="申请时间" prop="shenqingshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.shenqingshijian" 
						type="datetime"
						:readonly="ro.shenqingshijian"
						placeholder="申请时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-else-if="ruleForm.shenqingshijian" label="申请时间" prop="shenqingshijian">
					<el-input v-model="ruleForm.shenqingshijian" placeholder="申请时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="upload" v-if="type!='info'&& !ro.shenqingcailiao" label="申请材料" prop="shenqingcailiao">
					<file-upload
						tip="点击上传申请材料"
						action="file/upload"
						:limit="1"
						:type="3"
						:multiple="true"
						:fileUrls="ruleForm.shenqingcailiao?ruleForm.shenqingcailiao:''"
						@change="shenqingcailiaoUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else-if="ruleForm.shenqingcailiao" label="申请材料" prop="shenqingcailiao">
					<el-button :style='{"cursor":"pointer","padding":"0 30px","margin":"0 20px 0 0","borderColor":"#e2e2e4","color":"#333","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"1px","width":"auto","lineHeight":"36px","fontSize":"14px","borderStyle":"solid","height":"36px"}' type="text" size="small" @click="download($base.url+ruleForm.shenqingcailiao)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else-if="!ruleForm.shenqingcailiao" label="申请材料" prop="shenqingcailiao">
					<el-button :style='{"cursor":"pointer","padding":"0 30px","margin":"0 20px 0 0","borderColor":"#e2e2e4","color":"#333","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"1px","width":"auto","lineHeight":"36px","fontSize":"14px","borderStyle":"solid","height":"36px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="select" v-if="type!='info'"  label="开发进度" prop="kaifajindu">
					<el-select :disabled="ro.kaifajindu" v-model="ruleForm.kaifajindu" placeholder="请选择开发进度" >
						<el-option
							v-for="(item,index) in kaifajinduOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="开发进度" prop="kaifajindu">
					<el-input v-model="ruleForm.kaifajindu"
						placeholder="开发进度" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="林业局名称" prop="linyejumingcheng">
					<el-input v-model="ruleForm.linyejumingcheng" placeholder="林业局名称" clearable  :readonly="ro.linyejumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="林业局名称" prop="linyejumingcheng">
					<el-input v-model="ruleForm.linyejumingcheng" placeholder="林业局名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="企业名称" prop="qiyemingcheng">
					<el-input v-model="ruleForm.qiyemingcheng" placeholder="企业名称" clearable  :readonly="ro.qiyemingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="企业名称" prop="qiyemingcheng">
					<el-input v-model="ruleForm.qiyemingcheng" placeholder="企业名称" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"10px 150px 20px 0","margin":"30px 0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"center"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					保存
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
export default {
	data() {
		return {
			id: '',
			type: '',
			
			
			ro:{
				lindimingcheng : false,
				lindileixing : false,
				quyu : false,
				lindimianji : false,
				linditupian : false,
				shenqingshijian : false,
				shenqingcailiao : false,
				kaifajindu : false,
				linyejumingcheng : false,
				qiyemingcheng : false,
				sfsh : false,
				shhf : false,
			},
			
			
			ruleForm: {
				lindimingcheng: '',
				lindileixing: '',
				quyu: '',
				lindimianji: '',
				linditupian: '',
				shenqingshijian: '',
				shenqingcailiao: '',
				kaifajindu: '未开发',
				linyejumingcheng: '',
				qiyemingcheng: '',
				shhf: '',
			},
		
			kaifajinduOptions: [],

			
			rules: {
				lindimingcheng: [
				],
				lindileixing: [
				],
				quyu: [
				],
				lindimianji: [
				],
				linditupian: [
				],
				shenqingshijian: [
				],
				shenqingcailiao: [
					{ required: true, message: '申请材料不能为空', trigger: 'blur' },
				],
				kaifajindu: [
				],
				linyejumingcheng: [
				],
				qiyemingcheng: [
				],
				sfsh: [
				],
				shhf: [
				],
			},
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.shenqingshijian = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='lindimingcheng'){
							this.ruleForm.lindimingcheng = obj[o];
							this.ro.lindimingcheng = true;
							continue;
						}
						if(o=='lindileixing'){
							this.ruleForm.lindileixing = obj[o];
							this.ro.lindileixing = true;
							continue;
						}
						if(o=='quyu'){
							this.ruleForm.quyu = obj[o];
							this.ro.quyu = true;
							continue;
						}
						if(o=='lindimianji'){
							this.ruleForm.lindimianji = obj[o];
							this.ro.lindimianji = true;
							continue;
						}
						if(o=='linditupian'){
							this.ruleForm.linditupian = obj[o];
							this.ro.linditupian = true;
							continue;
						}
						if(o=='shenqingshijian'){
							this.ruleForm.shenqingshijian = obj[o];
							this.ro.shenqingshijian = true;
							continue;
						}
						if(o=='shenqingcailiao'){
							this.ruleForm.shenqingcailiao = obj[o];
							this.ro.shenqingcailiao = true;
							continue;
						}
						if(o=='kaifajindu'){
							this.ruleForm.kaifajindu = obj[o];
							this.ro.kaifajindu = true;
							continue;
						}
						if(o=='linyejumingcheng'){
							this.ruleForm.linyejumingcheng = obj[o];
							this.ro.linyejumingcheng = true;
							continue;
						}
						if(o=='qiyemingcheng'){
							this.ruleForm.qiyemingcheng = obj[o];
							this.ro.qiyemingcheng = true;
							continue;
						}
				}
				this.ruleForm.kaifajindu = '未开发'; 			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.shenqingshijian = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.kaifajindu = true;
					}
					if(((json.qiyemingcheng!=''&&json.qiyemingcheng) || json.qiyemingcheng==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.qiyemingcheng = json.qiyemingcheng
						this.ro.qiyemingcheng = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
            this.kaifajinduOptions = "已开发,未开发".split(',')
			
		},
    // 多级联动参数

		info(id) {
			this.$http({
				url: `kaifajihuashenqing/info/${id}`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.ruleForm = data.data;
					//解决前台上传图片后台不显示的问题
					let reg=new RegExp('../../../upload','g')//g代表全部
				} else {
					this.$message.error(data.msg);
				}
			});
		},


    // 提交
    onSubmit() {
	if(this.ruleForm.linditupian!=null) {
		this.ruleForm.linditupian = this.ruleForm.linditupian.replace(new RegExp(this.$base.url,"g"),"");
	}
	if(this.ruleForm.shenqingcailiao!=null) {
		this.ruleForm.shenqingcailiao = this.ruleForm.shenqingcailiao.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "kaifajihuashenqing/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `kaifajihuashenqing/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.kaifajihuashenqingCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `kaifajihuashenqing/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.kaifajihuashenqingCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
		});
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.kaifajihuashenqingCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    linditupianUploadChange(fileUrls) {
	    this.ruleForm.linditupian = fileUrls;
    },
    shenqingcailiaoUploadChange(fileUrls) {
	    this.ruleForm.shenqingcailiao = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  font-weight: 600;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  border-color: e2e2e4;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  border-color: e2e2e4;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  padding: 0 10px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #e2e2e4;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: #fff;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 300px;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  padding: 0 10px 0 30px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #e2e2e4;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: #fff;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  cursor: pointer;
	  	  color: #ccc;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e2e2e4;
	  	  line-height: 80px;
	  	  border-radius: 4px;
	  	  background: #fff;
	  	  width: 160px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  cursor: pointer;
	  	  color: #ccc;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e2e2e4;
	  	  line-height: 80px;
	  	  border-radius: 4px;
	  	  background: #fff;
	  	  width: 160px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  cursor: pointer;
	  	  color: #ccc;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e2e2e4;
	  	  line-height: 80px;
	  	  border-radius: 4px;
	  	  background: #fff;
	  	  width: 160px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  padding: 12px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #e2e2e4;
	  	  min-height: 120px;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: #fff;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 400px;
	  	  height: auto;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0px solid rgba(53, 184, 224, 0.1);
				cursor: pointer;
				padding: 0 10px;
				margin: 0px 10px 0 0;
				color: #fff;
				display: inline-block;
				font-size: 14px;
				line-height: 34px;
				border-radius: 2px;
				box-shadow: 0 4px #29b392;
				outline: none;
				background: #41cac0;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn1:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0px solid rgba(24, 138, 226, 0.1) ;
				cursor: pointer;
				padding: 0 10px;
				margin: 0px 10px 0 0;
				color: #fff;
				font-size: 14px;
				line-height: 34px;
				border-radius: 2px;
				box-shadow: 0 4px #cab03f;
				outline: none;
				background: #e4ba00;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn2:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0px solid #0260ad;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px 0 0;
				color: #fff;
				font-size: 14px;
				line-height: 24px;
				border-radius: 2px;
				box-shadow: 0 4px #1caadc;
				outline: none;
				background: #58c9f3;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn3:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px 0 0;
				color: #fff;
				font-size: 14px;
				line-height: 34px;
				border-radius: 2px;
				box-shadow: 0 4px #61a642;
				outline: none;
				background: #78CD51;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn4:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 1px solid #cecece;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px 0 0;
				color: #ACA9A9;
				font-size: 14px;
				line-height: 34px;
				border-radius: 2px;
				box-shadow: 0 4px #9c9c9c;
				outline: none;
				background: #fff;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn5:hover {
				transform: translate3d(0px, 6px, 0px);
				background: #ececec;
				opacity: 1;
			}
</style>
