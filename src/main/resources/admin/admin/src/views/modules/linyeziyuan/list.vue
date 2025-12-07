<template>
	<div class="main-content" :style='{"minHeight":"100vh","padding":"0px 0px 20px","overflow":"hidden","color":"#666","background":"#e5e6e6","fontSize":"14px","position":"relative"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"border":"0px solid #bababa","padding":"20px","margin":"0px 0 0","overflow":"hidden","borderRadius":"0px","background":"none","width":"auto","fontSize":"inherit"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"20px","borderColor":"#355749","color":"#c2c2c2","textAlign":"center","flexDirection":"row","display":"flex","borderRadius":"4px","flexWrap":"wrap","background":"#fff","borderWidth":"2px 0 0","width":"100%","fontSize":"inherit","borderStyle":"solid"}' >
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","flexWrap":"wrap","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#797979","display":"inline-block","lineHeight":"32px","fontSize":"inherit","fontWeight":"500","height":"32px"}' class="item-label">林地名称</label>
						<el-input v-model="searchForm.lindimingcheng" placeholder="林地名称" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","flexWrap":"wrap","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#797979","display":"inline-block","lineHeight":"32px","fontSize":"inherit","fontWeight":"500","height":"32px"}' class="item-label">林地类型</label>
						<el-input v-model="searchForm.lindileixing" placeholder="林地类型" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","flexWrap":"wrap","display":"flex"}' class="select" label="区域" prop="quyu">
						<label :style='{"margin":"0 10px 0 0","color":"#797979","display":"inline-block","lineHeight":"32px","fontSize":"inherit","fontWeight":"500","height":"32px"}' class="item-label">区域</label>
						<el-select clearable v-model="searchForm.quyu" placeholder="请选择区域" >
							<el-option v-for="(item,index) in quyuOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","flexWrap":"wrap","display":"flex"}' class="select" label="申请状态" prop="shenqingzhuangtai">
						<label :style='{"margin":"0 10px 0 0","color":"#797979","display":"inline-block","lineHeight":"32px","fontSize":"inherit","fontWeight":"500","height":"32px"}' class="item-label">申请状态</label>
						<el-select clearable v-model="searchForm.shenqingzhuangtai" placeholder="请选择申请状态" >
							<el-option v-for="(item,index) in shenqingzhuangtaiOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-chakan12" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
						搜索
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"padding":"20px 20px 10px","margin":"20px 0 0","borderColor":"#355749","color":"#fff","textAlign":"left","flexDirection":"row","display":"block","borderRadius":"4px","flexWrap":"wrap","background":"#fff","borderWidth":"2px 0 0","width":"100%","fontSize":"inherit","borderStyle":"solid"}'>
					<el-button class="add" v-if="isAuth('linyeziyuan','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia13" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						新增
					</el-button>
					<el-button class="del" v-if="isAuth('linyeziyuan','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu7" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
						删除
					</el-button>

					<el-button class="btn18" v-if="isAuth('linyeziyuan','导入')" type="success" @click="importHandler()">
						<span class="icon iconfont icon-daoru6" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						导入
					</el-button>
					<el-button class="btn18" v-if="isAuth('linyeziyuan','上传模板')" type="success" @click="importClcik">
						<span class="icon iconfont icon-shangchuan1" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						上传模板
					</el-button>
					<el-button class="btn18" v-if="isAuth('linyeziyuan','下载模板')" type="success" @click="download('upload/linyeziyuan_template.xlsx')">
						<span class="icon iconfont icon-xiazai7" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						下载模板
					</el-button>

					<download-excel v-if="isAuth('linyeziyuan','导出')" class="export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "林业资源.xls">
						<!-- 导出excel -->
						<el-button class="btn18" type="success">
							<span class="icon iconfont icon-daochu4" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
							导出
						</el-button>
					</download-excel>
					<el-button class="btn18" v-if="isAuth('linyeziyuan','生成数据')" type="success" @click="genDataClick()">
						<span class="icon iconfont icon-shuju17" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						生成数据
					</el-button>

					<el-button class="btn18" v-if="isAuth('linyeziyuan','林地类型')" type="success" @click="chartDialog1()">
						<span class="icon iconfont icon-a-fenxiang2" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						林地类型
					</el-button>
					<el-button class="btn18" v-if="isAuth('linyeziyuan','林地数据')" type="success" @click="chartDialog2()">
						<span class="icon iconfont icon-a-fenxiang2" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						林地数据
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"border":"0px solid #e1e8ee","padding":"0px","margin":"0px auto","borderColor":"#355749","borderRadius":"4px","background":"rgba(255,255,255,1)","borderWidth":"2px 0 0","width":"calc(100% - 40px)","borderStyle":"solid"}'>
				<el-table class="tables"
					:stripe='true'
					:style='{"padding":"0","borderColor":"#f4f4f4","color":"inherit","borderRadius":"4px","borderWidth":"1px 0px 0 1px","background":"none","width":"100%","fontSize":"inherit","borderStyle":"solid"}' 
					:border='true'
					v-if="isAuth('linyeziyuan','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="lindimingcheng"
						label="林地名称">
						<template slot-scope="scope">
							{{scope.row.lindimingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="lindileixing"
						label="林地类型">
						<template slot-scope="scope">
							{{scope.row.lindileixing}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="quyu"
						label="区域">
						<template slot-scope="scope">
							{{scope.row.quyu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="lindimianji"
						label="林地面积">
						<template slot-scope="scope">
							{{scope.row.lindimianji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="linzhongleixing"
						label="林种类型">
						<template slot-scope="scope">
							{{scope.row.linzhongleixing}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="senlinfugailv"
						label="森林覆盖率">
						<template slot-scope="scope">
							{{scope.row.senlinfugailv}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="linmuxujiliang"
						label="林木蓄积量">
						<template slot-scope="scope">
							{{scope.row.linmuxujiliang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="shenqingzhuangtai"
						label="申请状态">
						<template slot-scope="scope">
							{{scope.row.shenqingzhuangtai}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="linditupian" width="200" label="林地图片">
						<template slot-scope="scope">
							<div v-if="scope.row.linditupian">
								<img v-if="scope.row.linditupian.substring(0,4)=='http'" :src="scope.row.linditupian.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView(scope.row.linditupian.split(',')[0])">
								<img v-else :src="$base.url+scope.row.linditupian.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView($base.url+scope.row.linditupian.split(',')[0])">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="linyejumingcheng"
						label="林业局名称">
						<template slot-scope="scope">
							{{scope.row.linyejumingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="clicknum"
						label="点击次数">
						<template slot-scope="scope">
							{{scope.row.clicknum}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="storeupnum"
						label="收藏数">
						<template slot-scope="scope">
							{{scope.row.storeupnum}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('linyeziyuan','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan14" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								查看
							</el-button>
							<el-button class="btn8" v-if="isAuth('linyeziyuan','开发申请')" @click="kaifajihuashenqingCrossAddOrUpdateHandler(scope.row,'cross','','','shenqingzhuangtai','已申请','已申请,待申请'.split(',')[0])" type="success">
								<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								开发申请
							</el-button>
							<el-button class="edit" v-if=" isAuth('linyeziyuan','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai10" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								修改
							</el-button>




							<el-button class="del" v-if="isAuth('linyeziyuan','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-guanbi1" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								删除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="上一页 "
				next-text="下一页 "
				:hide-on-single-page="false"
				:style='{"padding":"8px 20px 4px","margin":"20px auto","borderColor":"#355749","whiteSpace":"nowrap","color":"inherit","textAlign":"left","clear":"both","borderRadius":"4px","background":"#fff","borderWidth":"2px 0 0","width":"calc(100% - 40px)","fontSize":"inherit","borderStyle":"solid","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<kaifajihuashenqing-cross-add-or-update v-if="kaifajihuashenqingCrossAddOrUpdateFlag" :parent="this" ref="kaifajihuashenqingCrossaddOrUpdate"></kaifajihuashenqing-cross-add-or-update>


		<el-dialog title="导入" :visible.sync="importVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item class="upload" label="文件" prop="excelFile">
				  <excel-file-upload
				  tip="点击上传直接导入excel文件"
				  action="linyeziyuan/importExcel"
				  :limit="1"
				  :fileUrls="importUrl"
                  @change="importChange"
				  ></excel-file-upload>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="importHandler()">关 闭</el-button>
			</span>
		</el-dialog>
        <el-dialog title="上传模板" :visible.sync="importVis" width="50%">
            <el-form ref="form" :model="importForm" label-width="80px">
                <el-form-item class="upload" label="文件" prop="excelFile">
                    <el-upload class="upload-demo" drag :action="$base.url + 'file/upload?type=linyeziyuan_template'"
                        :show-file-list="false" :on-success="importSuccess">
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                    </el-upload>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="importVis=false">关 闭</el-button>
            </span>
        </el-dialog>

		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="lindileixingChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog
		  :visible.sync="chartVisiable2"
		  width="800">
			<div id="lindimingchengChart2" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog2">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog :title="'生成数据'" :visible.sync="genDataVisible" width="50%">
			<el-form ref="form" :model="genDataForm" label-width="100px">
				<el-form-item label="数据量">
					<el-input-number v-model="genDataForm.recordNum" :min="1" :max="3000" label="数据量"></el-input-number>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="genDataVisible = false">关闭</el-button>
				<el-button @click="genDataSave" type="primary">生成</el-button>
			</span>
		</el-dialog>

		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>

<script>
import * as echarts from 'echarts'
import chinaJson from "@/components/echarts/china.json";
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import kaifajihuashenqingCrossAddOrUpdate from "../kaifajihuashenqing/add-or-update";
import {
  Loading
} from 'element-ui'
	export default {
		data() {
			return {
				quyuOptions: [],
				shenqingzhuangtaiOptions: [],
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				importVisiable: false,
				importVis: false,
				importForm: {},
				importUrl: '',
				chartVisiable1: false,
				chartVisiable2: false,
				addOrUpdateFlag:false,
				kaifajihuashenqingCrossAddOrUpdateFlag: false,
				layouts: ["pager","jumper"],
//导出excel
				json_fields: {
					"林地名称": "lindimingcheng",    //常规字段
					"林地类型": "lindileixing",    //常规字段
					"区域": "quyu",    //常规字段
					"林地面积": "lindimianji",    //常规字段
					"林种类型": "linzhongleixing",    //常规字段
					"森林覆盖率": "senlinfugailv",    //常规字段
					"林木蓄积量": "linmuxujiliang",    //常规字段
					"申请状态": "shenqingzhuangtai",    //常规字段
					"林地图片": "linditupian",    //常规字段
					"林业局名称": "linyejumingcheng",    //常规字段
					"最近点击时间": "clicktime",    //常规字段
					"点击次数": "clicknum",    //常规字段
					"收藏数": "storeupnum",    //常规字段
				},
				json_meta: [
					[
						{
							" key ": " charset ",
							" value ": " utf- 8 "
						}
					]
				],
				genDataVisible: false,
				genDataForm: {},
				previewImg: '',
				previewVisible: false,
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
		},
		components: {
			AddOrUpdate,
			kaifajihuashenqingCrossAddOrUpdate,
		},
		methods: {
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
			},
			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},
			kaifajihuashenqingCrossAddOrUpdateHandler(row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue){
				this.showFlag = false;
				this.addOrUpdateFlag = false;
				this.kaifajihuashenqingCrossAddOrUpdateFlag = true;
				this.$storage.set('crossObj',row);
				this.$storage.set('crossTable','linyeziyuan');
				this.$storage.set('statusColumnName',statusColumnName);
				this.$storage.set('statusColumnValue',statusColumnValue);
				this.$storage.set('tips',tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$message({
								message: tips,
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList();
								}
							});
							this.showFlag = true;
							this.kaifajihuashenqingCrossAddOrUpdateFlag = false;
							return;
						}
					}
				}
				this.$nextTick(() => {
					this.$refs.kaifajihuashenqingCrossaddOrUpdate.init(row.id,type);
				});
			},


//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{
        var lindileixingChart1 = echarts.init(document.getElementById("lindileixingChart1"),'macarons');
        this.$http({
            url: "linyeziyuan/group/lindileixing",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].lindileixing);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].lindileixing
                    })
                }
                var option = {};
                option = {
                        title: {
                            text: '林地类型',
                            left: 'center'
                        },
                        legend: {
                          orient: 'vertical',
                          left: 'left'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: ['25%', '55%'],
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                lindileixingChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    lindileixingChart1.resize();
                };
            }
        });
      })
    },

//统计接口
    chartDialog2() {
      this.chartVisiable2 = !this.chartVisiable2;
      this.$nextTick(()=>{
        // lindimingcheng lindimingcheng

        var lindimingchengChart2 = echarts.init(document.getElementById("lindimingchengChart2"),'macarons');
        this.$http({
            url: `linyeziyuan/valueMul/lindimingcheng?yColumnNameMul=senlinfugailv,linmuxujiliang`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis1 = [];
                let yAxis1 = [];
                let pArray1 = []
                for(let i=0;i<res[0].length;i++){
                    xAxis1.push(res[0][i].lindimingcheng);
                    yAxis1.push(parseFloat((res[0][i].total)));
                    pArray1.push({
                        value: parseFloat((res[0][i].total)),
                        name: res[0][i].lindimingcheng
                    })
                }
                let xAxis2 = [];
                let yAxis2 = [];
                let pArray2 = []
                for(let i=0;i<res[1].length;i++){
                    xAxis2.push(res[1][i].lindimingcheng);
                    yAxis2.push(parseFloat((res[1][i].total)));
                    pArray2.push({
                        value: parseFloat((res[1][i].total)),
                        name: res[1][i].lindimingcheng
                    })
                }
                var option = {};
                option = {
                    title: {
                        left: 'left'
                    },
                    legend: {
                        data: [
                                '森林覆盖率',
                                '林木积蓄量',
                              ]
                    },
                    tooltip: {
                      trigger: 'axis',
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis1
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                    {
                        data: yAxis1,
                        type: 'line',
                        name: '森林覆盖率',
                    },
                    {
                        data: yAxis2,
                        type: 'line',
                        name: '林木积蓄量',
                    },
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                lindimingchengChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    lindimingchengChart2.resize();
                };
            }
        });
      })
    },



    init () {
          this.$http({
            url: `option/quyu/quyu`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.quyuOptions = data.data;
            } else {
              this.$message.error(data.msg);
            }
          });
          this.shenqingzhuangtaiOptions = "已申请,待申请".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.lindimingcheng!='' && this.searchForm.lindimingcheng!=undefined){
            params['lindimingcheng'] = '%' + this.searchForm.lindimingcheng + '%'
          }
           if(this.searchForm.lindileixing!='' && this.searchForm.lindileixing!=undefined){
            params['lindileixing'] = '%' + this.searchForm.lindileixing + '%'
          }
          if(this.searchForm.quyu!='' && this.searchForm.quyu!=undefined){
            params['quyu'] = this.searchForm.quyu
          }
          if(this.searchForm.shenqingzhuangtai!='' && this.searchForm.shenqingzhuangtai!=undefined){
            params['shenqingzhuangtai'] = this.searchForm.shenqingzhuangtai
          }
			let user = JSON.parse(this.$storage.getObj('userForm'))
			console.log(user)
			this.$http({
				url: "linyeziyuan/page",
				method: "get",
				params: params
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.dataList = data.data.list;
					this.totalPage = data.data.total;
				} else {
					this.dataList = [];
					this.totalPage = 0;
				}
				this.dataListLoading = false;
			});
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    importChange(){
		
        this.importHandler()
        this.getDataList()
    },
    importClcik() {
        this.importVis = true
    },
    importSuccess(e) {
        if(e.code==0){
            this.$message.success('上传成功');
            this.importVis = false
            
        }
    },
    importHandler() {
		this.importUrl = ''
        this.importVisiable = !this.importVisiable;
    },
    // 下载
    download(file){
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.$base.url + 'file/download?fileName=' + arr, {
      	headers: {
      		token: this.$storage.get('Token')
      	},
      	responseType: "blob"
      }).then(({
      	data
      }) => {
      	const binaryData = [];
      	binaryData.push(data);
      	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
      		type: 'application/pdf;chartset=UTF-8'
      	}))
      	const a = document.createElement('a')
      	a.href = objectUrl
      	a.download = arr
      	// a.click()
      	// 下面这个写法兼容火狐
      	a.dispatchEvent(new MouseEvent('click', {
      		bubbles: true,
      		cancelable: true,
      		view: window
      	}))
      	window.URL.revokeObjectURL(data)
      },err=>{
		  axios.get((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: this.$storage.get('Token')
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  })
	  })
    },
	linyeziyuanstatusChange(e,row){
		if(row.status==0){
			row.passwordwrongnum = 0
		}
		this.$http({
			url:'linyeziyuan/update',
			method:'post',
			data:row
		}).then(res=>{
			if(row.status==1){
				this.$message.error('该用户已锁定')
			}else{
				this.$message.success('该用户已解除锁定')
			}
		})
	},
    // 删除
    async deleteHandler(id ) {
		var ids = id? [Number(id)]: this.dataListSelections.map(item => {
			return Number(item.id);
		});
		await this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
			confirmButtonText: "确定",
			cancelButtonText: "取消",
			type: "warning"
		}).then(async () => {
			await this.$http({
				url: "linyeziyuan/delete",
				method: "post",
				data: ids
			}).then(async ({ data }) => {
				if (data && data.code === 0) {
					for(let x in ids){
						await this.$http.get('storeup/list',{params: {
							page: 1,
							limit: 100,
							refid: ids[x],
							tablename: 'linyeziyuan'
						}}).then(async obj=>{
							if(obj.data&&obj.data.code==0){
								if(obj.data.data.list.length){
									let arr = []
									for(let i in obj.data.data.list){
										arr.push(obj.data.data.list[i].id)
									}
									await this.$http.post('storeup/delete',arr).then(()=>{})
								}
							}
						})
					}
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.search();
						}
					});
            
				} else {
					this.$message.error(data.msg);
				}
			});
		});
    },


	// 数据生成
	genDataClick(){
		this.genDataVisible = true
		this.genDataForm = {
			recordNum: 0
		}
	},
	genDataSave(){
		this.genDataVisible = false
        let loading = null
        loading = Loading.service({
			target: this.$refs['roleMenuBox'],
			fullscreen: false,
			text: '数据生成中...'
        })
		this.$http({
			url: 'linyeziyuan/batch/gen?recordNum=' + this.genDataForm.recordNum,
			method: 'post'
		}).then(res=>{
			if(res.data&&res.data.code==0){
				if (loading) loading.close()
				this.$message({
				    message: "数据生成成功！",
				    type: "success",
				    duration: 1500,
				    onClose: () => {
				        
				        this.getDataList()
				    }
				});
				
			}
		})
	},
  }

};
</script>
<style lang="scss" scoped>
	//导出excel
	.export-excel-wrapper{
		display: inline-block;
	}
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #e2e2e4;
				border-radius: 4px;
				padding: 0 12px;
				outline: none;
				color: inherit;
				background: #fff;
				width: 150px;
				font-size: inherit;
				height: 32px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #e2e2e4;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: inherit;
				background: #fff;
				width: 150px;
				font-size: inherit;
				height: 34px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #e2e2e4;
				border-radius: 4px;
				padding: 0 10px 0 30px;
				outline: none;
				color: inherit;
				background: #fff;
				width: 150px;
				font-size: inherit;
				height: 34px;
			}
	
	.center-form-pv .search {
				cursor: pointer;
				padding: 0 20px;
				margin: 0 10px;
				color: #fff;
				font-size: 14px;
				border-color: #1576c2;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: #78CD51;
				width: auto;
				border-width: 0 0 0px;
				border-style: solid;
				min-width: 80px;
				height: 34px;
			}
	
	.center-form-pv .search:hover {
				color: #fff;
				background: #67b344;
			}
	
	.center-form-pv .actions .add {
				border: 0px solid #03a9f4;
				cursor: pointer;
				border-radius: 2px;
				padding: 0px 20px;
				box-shadow: 0 4px #1caadc;
				margin: 0 8px 10px 0;
				color: #fff;
				background: #58c9f3;
				width: auto;
				font-size: inherit;
				height: 34px;
			}
	
	.center-form-pv .actions .add:hover {
				color: #fff;
				background: #4dbce5;
			}
	
	.center-form-pv .actions .del {
				border: 0px solid #ed5564;
				cursor: pointer;
				border-radius: 2px;
				padding: 0 20px;
				box-shadow: 0 4px #d1595a;
				margin: 0 8px 10px 0;
				color: #fff;
				background: #ff6c60;
				width: auto;
				font-size: inherit;
				height: 34px;
			}
	
	.center-form-pv .actions .del:hover {
				color: #fff;
				background: #ef665b;
			}
	
	.center-form-pv .actions .statis {
				border: 0px solid #7dc855;
				cursor: pointer;
				border-radius: 2px;
				padding: 0 20px;
				box-shadow: 0 4px #61a642;
				margin: 0 8px 10px 0;
				color: #fff;
				background: #78CD51;
				width: auto;
				font-size: inherit;
				height: 34px;
			}
	
	.center-form-pv .actions .statis:hover {
				background: #70be4d;
			}
	
	.center-form-pv .actions .btn18 {
				border: 1px solid #cecece;
				cursor: pointer;
				border-radius: 2px;
				padding: 0 20px;
				box-shadow: 0 4px #9c9c9c;
				margin: 0 8px 10px 0;
				color: #ACA9A9;
				background: #fff;
				width: auto;
				font-size: inherit;
				height: 34px;
			}
	
	.center-form-pv .actions .btn18:hover {
				background: #ececec;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: inherit;
				background: rgba(254,169,34,0);
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				color: #797979;
				background: none;
				border-color: #ddd;
				border-width: 0 0px 2px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: 600;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				padding: 0;
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 2px 0;
				color: inherit;
				background: none;
				font-size: inherit;
				border-color: #ddd;
				border-width: 0 0px 1px 0px;
				border-style: solid;
				text-align: left;
			}
	
		.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: #f9f9f9;
	}
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 2px 0;
				color: inherit;
				background: #f9f9f9;
				border-color: #ddd;
				border-width: 0 0px 1px 0px;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 2px 0;
				color: inherit;
				background: none;
				font-size: inherit;
				border-color: #ddd;
				border-width: 0 0px 1px 0px;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				color: inherit;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
				border: 0px solid rgba(24, 138, 226, 0.1);
				cursor: pointer;
				padding: 0 16px;
				margin: 0 5px 5px 0;
				color: #fff;
				font-size: 12px;
				border-radius: 2px;
				box-shadow: 0 2px #1caadc;
				outline: none;
				background: #58c9f3;
				width: auto;
				min-width: 40px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
				border: 0px solid rgba(16, 196, 105, 0.1) ;
				cursor: pointer;
				padding: 0 16px;
				margin: 0 5px 5px 0;
				color: #fff;
				font-size: 12px;
				border-radius: 2px;
				box-shadow: 0 2px #61a642;
				outline: none;
				background: #78CD51;
				width: auto;
				min-width: 40px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
				border: 0px solid rgba(255, 91, 91, 0.1);
				cursor: pointer;
				border-radius: 2px;
				padding: 0 16px;
				box-shadow: 0 2px #d1595a;
				margin: 0 5px 5px 0;
				outline: none;
				color: #fff;
				background: #ff6c60;
				width: auto;
				font-size: 12px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
				border: 1px solid #cecece;
				cursor: pointer;
				border-radius: 2px;
				padding: 0 16px;
				box-shadow: 0 2px #9c9c9c;
				margin: 0 5px 5px 0;
				color: #ACA9A9;
				background: #fff;
				width: auto;
				font-size: 12px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: inherit;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				border: 1px solid #eee;
				padding: 0 4px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #ec6459;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #ec6459;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				color: inherit;
				width: 100px;
				font-size: inherit;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 0px solid #ddd;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: none;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				color: inherit;
				display: inline-block;
				width: 50px;
				font-size: inherit;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #eee;
				cursor: pointer;
				padding: 0 0px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 24px;
				border-radius: 3px;
				outline: 0;
				background: none;
				width: auto;
				text-align: center;
				height: 24px;
			}
	
	// list one
	.one .list1-view {
				border: 1px solid #0260ad30;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #333;
				background: linear-gradient(45deg, rgba(233,245,255,1) 0%, rgba(253,254,255,1) 50%, rgba(233,245,255,1) 100%);
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-view:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.one .list1-edit {
				border: 1px solid #0260ad30;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #333;
				background: linear-gradient(45deg, rgba(233,245,255,1) 0%, rgba(253,254,255,1) 50%, rgba(233,245,255,1) 100%);
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-edit:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.one .list1-del {
				border: 1px solid #0260ad30;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #333;
				background: linear-gradient(45deg, rgba(233,245,255,1) 0%, rgba(253,254,255,1) 50%, rgba(233,245,255,1) 100%);
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-del:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.one .list1-btn8 {
				border: 1px solid #0260ad30;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #333;
				background: linear-gradient(45deg, rgba(233,245,255,1) 0%, rgba(253,254,255,1) 50%, rgba(233,245,255,1) 100%);
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-btn8:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.main-content .el-table .el-switch {
				display: inline-flex;
				vertical-align: middle;
				line-height: 30px;
				position: relative;
				align-items: center;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
				cursor: pointer;
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
				border: 0px solid #188ae2;
				cursor: pointer;
				border-radius: 20px;
				margin: 0;
				outline: 0;
				background: #b0d5f6;
				display: inline-block;
				width: 40px;
				box-sizing: border-box;
				transition: border-color .3s,background-color .3s;
				height: 18px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
				border-radius: 100%;
				top: 1px;
				left: 1px;
				background: #FFF;
				width: 16px;
				position: absolute;
				transition: all .3s;
				height: 16px;
			}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
				margin: 0 0 0 -17px;
				left: 100%;
			}
	
	.main-content .el-table .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				color: #212529;
				display: inline-block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}

</style>
