<template>
<div :style='{"width":"100%","padding":"30px 7% 40px","margin":"0px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"border":"0px solid #28890b30","width":"100%","padding":"30px","position":"relative","background":"#fff"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="政策名称" prop="zhengcemingcheng">
            <el-input v-model="ruleForm.zhengcemingcheng" 
                placeholder="政策名称" clearable :disabled=" false  ||ro.zhengcemingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="政策类型" prop="zhengceleixing">
            <el-select v-model="ruleForm.zhengceleixing" placeholder="请选择政策类型" :disabled=" false  ||ro.zhengceleixing" >
              <el-option
                  v-for="(item,index) in zhengceleixingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="申请条件" prop="shenqingtiaojian">
            <el-input v-model="ruleForm.shenqingtiaojian" 
                placeholder="申请条件" clearable :disabled=" false  ||ro.shenqingtiaojian"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="发布日期" prop="faburiqi">
              <el-date-picker
				  :disabled="true  ||ro.faburiqi"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.faburiqi" 
                  type="date"
                  placeholder="发布日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="政策图片" v-if="type!='cross' || (type=='cross' && !ro.zhengcetupian)" prop="zhengcetupian">
            <file-upload
            tip="点击上传政策图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.zhengcetupian?ruleForm.zhengcetupian:''"
            @change="zhengcetupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="政策图片" prop="zhengcetupian">
                <img v-if="ruleForm.zhengcetupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.zhengcetupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.zhengcetupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="林业局名称" prop="linyejumingcheng">
            <el-input v-model="ruleForm.linyejumingcheng" 
                placeholder="林业局名称" clearable :disabled=" false  ||ro.linyejumingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="政策内容" prop="zhengceneirong">
            <editor 
                :style='{"minHeight":"250px","padding":"0","margin":"0","borderColor":"#1abc9e30","backgroundColor":"none","borderRadius":"0","borderWidth":"0px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.zhengceneirong" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0px","background":"#28890b","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid #eee","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"0px","background":"#f95927","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				zhengcemingcheng : false,
				zhengceleixing : false,
				shenqingtiaojian : false,
				zhengceneirong : false,
				faburiqi : false,
				zhengcetupian : false,
				linyejumingcheng : false,
				discussnum : false,
				storeupnum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          zhengcemingcheng: '',
          zhengceleixing: '',
          shenqingtiaojian: '',
          zhengceneirong: '',
          faburiqi: '',
          zhengcetupian: '',
          linyejumingcheng: '',
          discussnum: '',
          storeupnum: '',
        },
        zhengceleixingOptions: [],


        rules: {
          zhengcemingcheng: [
          ],
          zhengceleixing: [
          ],
          shenqingtiaojian: [
          ],
          zhengceneirong: [
          ],
          faburiqi: [
          ],
          zhengcetupian: [
          ],
          linyejumingcheng: [
          ],
          discussnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.faburiqi = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='zhengcemingcheng'){
              this.ruleForm.zhengcemingcheng = obj[o];
              this.ro.zhengcemingcheng = true;
              continue;
            }
            if(o=='zhengceleixing'){
              this.ruleForm.zhengceleixing = obj[o];
              this.ro.zhengceleixing = true;
              continue;
            }
            if(o=='shenqingtiaojian'){
              this.ruleForm.shenqingtiaojian = obj[o];
              this.ro.shenqingtiaojian = true;
              continue;
            }
            if(o=='zhengceneirong'){
              this.ruleForm.zhengceneirong = obj[o];
              this.ro.zhengceneirong = true;
              continue;
            }
            if(o=='faburiqi'){
              this.ruleForm.faburiqi = obj[o];
              this.ro.faburiqi = true;
              continue;
            }
            if(o=='zhengcetupian'){
              this.ruleForm.zhengcetupian = obj[o].split(",")[0];
              this.ro.zhengcetupian = true;
              continue;
            }
            if(o=='linyejumingcheng'){
              this.ruleForm.linyejumingcheng = obj[o];
              this.ro.linyejumingcheng = true;
              continue;
            }
            if(o=='discussnum'){
              this.ruleForm.discussnum = obj[o];
              this.ro.discussnum = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.linyejumingcheng!=''&&json.linyejumingcheng) || json.linyejumingcheng==0){
                this.ruleForm.linyejumingcheng = json.linyejumingcheng;
				this.ro.linyejumingcheng = true;
            }
          }
        });
        this.$http.get('option/zhengceleixing/zhengceleixing', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.zhengceleixingOptions = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`linyezhengce/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('linyezhengce/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`linyezhengce/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`linyezhengce/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
			this.$router.go(-1);
		},
      zhengcetupianUploadChange(fileUrls) {
          this.ruleForm.zhengcetupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #ddd;
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-radius: 0px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 1px solid #ddd;
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-radius: 0px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px;
	  color: #666;
	  background: none;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: none;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
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
	  color: #28890b60;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #28890b60;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #28890b60;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #28890b30;
	  border-radius: 0px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: none;
	  width: auto;
	  font-size: 14px;
	  min-width: 800px;
	  height: 120px;
	}
</style>
