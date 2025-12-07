<template>
  <div :style='{"minHeight":"100vh","padding":"0px 0px 20px","overflow":"hidden","color":"#666","background":"#e5e6e6","fontSize":"14px","position":"relative"}'>
    <el-form
	  :style='{"padding":"30px 30px 20px","borderColor":"#355749","borderRadius":"4px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,1)","borderWidth":"2px 0 0","display":"block","fontSize":"inherit","borderStyle":"solid"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="150px"
    >  
     <el-row>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='gongzuorenyuan'"  label="工号" prop="gonghao">
          <el-input v-model="ruleForm.gonghao" readonly              placeholder="工号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='gongzuorenyuan'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='gongzuorenyuan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in gongzuorenyuanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='gongzuorenyuan'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='gongzuorenyuan'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="gongzuorenyuantouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='shilinyeju'"  label="林业局名称" prop="linyejumingcheng">
          <el-input v-model="ruleForm.linyejumingcheng" readonly              placeholder="林业局名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='shilinyeju'"  label="负责人" prop="fuzeren">
          <el-input v-model="ruleForm.fuzeren"               placeholder="负责人" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='shilinyeju'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in shilinyejuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='shilinyeju'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='shilinyeju'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="shilinyejutouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='kaifaqiye'"  label="企业名称" prop="qiyemingcheng">
          <el-input v-model="ruleForm.qiyemingcheng" readonly              placeholder="企业名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='kaifaqiye'"  label="负责人" prop="fuzeren">
          <el-input v-model="ruleForm.fuzeren"               placeholder="负责人" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='kaifaqiye'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in kaifaqiyexingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='kaifaqiye'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='kaifaqiye'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="kaifaqiyetouxiangUploadChange"
          ></file-upload>
        </el-form-item>
		<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 16px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='users'" label="头像" prop="image">
		  <file-upload
		  tip="点击上传头像"
		  action="file/upload"
		  :limit="1"
		  :multiple="false"
		  :fileUrls="ruleForm.image?ruleForm.image:''"
		  @change="usersimageUploadChange"
		  ></file-upload>
		</el-form-item>
		<el-form-item :style='{"padding":"10px 150px 20px 0","margin":"30px 0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"center"}'>
			<el-button class="btn3" :style='{"border":"0px solid #0260ad","cursor":"pointer","padding":"0 20px","boxShadow":"0 4px #1caadc","margin":"0px 10px 0 0","color":"#fff","outline":"none","borderRadius":"2px","background":"#58c9f3","width":"auto","fontSize":"14px","lineHeight":"24px","height":"34px"}' type="primary" @click="onUpdateHandler">
				<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
				保存
			</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      gongzuorenyuanxingbieOptions: [],
      shilinyejuxingbieOptions: [],
      kaifaqiyexingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.gongzuorenyuanxingbieOptions = "男,女".split(',')
    this.shilinyejuxingbieOptions = "男,女".split(',')
    this.kaifaqiyexingbieOptions = "男,女".split(',')
  },
  methods: {
    gongzuorenyuantouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    shilinyejutouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    kaifaqiyetouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
	usersimageUploadChange(fileUrls) {
		this.ruleForm.image = fileUrls;
	},
    onUpdateHandler() {
      if((!this.ruleForm.gonghao)&& 'gongzuorenyuan'==this.flag){
        this.$message.error('工号不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'gongzuorenyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

      if((!this.ruleForm.xingming)&& 'gongzuorenyuan'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }


      if((!this.ruleForm.xingbie)&& 'gongzuorenyuan'==this.flag){
        this.$message.error('性别不能为空');
        return
      }


      if((!this.ruleForm.shouji)&& 'gongzuorenyuan'==this.flag){
        this.$message.error('手机不能为空');
        return
      }


      if( 'gongzuorenyuan' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }


        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.linyejumingcheng)&& 'shilinyeju'==this.flag){
        this.$message.error('林业局名称不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'shilinyeju'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

      if((!this.ruleForm.fuzeren)&& 'shilinyeju'==this.flag){
        this.$message.error('负责人不能为空');
        return
      }


      if((!this.ruleForm.xingbie)&& 'shilinyeju'==this.flag){
        this.$message.error('性别不能为空');
        return
      }


      if((!this.ruleForm.shouji)&& 'shilinyeju'==this.flag){
        this.$message.error('手机不能为空');
        return
      }


      if( 'shilinyeju' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }


        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.qiyemingcheng)&& 'kaifaqiye'==this.flag){
        this.$message.error('企业名称不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'kaifaqiye'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

      if((!this.ruleForm.fuzeren)&& 'kaifaqiye'==this.flag){
        this.$message.error('负责人不能为空');
        return
      }


      if((!this.ruleForm.xingbie)&& 'kaifaqiye'==this.flag){
        this.$message.error('性别不能为空');
        return
      }


      if((!this.ruleForm.shouji)&& 'kaifaqiye'==this.flag){
        this.$message.error('手机不能为空');
        return
      }


      if( 'kaifaqiye' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }


        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
	  if(this.flag=='users'){
	  	this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
	  }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
				if(this.flag=='users'){
					this.$storage.set('headportrait',this.ruleForm.image)
				}
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
	
	.add-update-preview .btn3 {
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
	
	.add-update-preview .btn3:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
