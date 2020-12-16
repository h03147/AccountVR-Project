<template>
    <div v-if="ideatitystatus == 'teacher'">
        <div class="headdiv1">
            <h1 class="h1data">信息录入</h1>
            <HR class="hrline" align=center width=300 color=#5D998B SIZE=1></HR>
        </div>
        <el-form :inline="true" :model="addstudentForm" :rules="rules" ref="addstudentForm" label-width="100px" class="demo-ruleForm">

            <el-form-item  prop="username">
                <el-input size="medium" type="text" v-model="addstudentForm.username" placeholder="学生姓名"></el-input>
            </el-form-item>
            <el-form-item  prop="sno">
                <el-input size="medium" type="text" v-model="addstudentForm.sno" placeholder="学生学号"></el-input>
            </el-form-item>
            <el-form-item  prop="password">
                <el-input size="medium" type="password" v-model="addstudentForm.password" placeholder="登录密码" show-password></el-input>
            </el-form-item>
            <el-form-item>
                <el-button class="addbutton1" size="medium" type="primary" @click="submitForm('addstudentForm')">添加</el-button>
            </el-form-item>
            <el-form-item>
                <el-button class="resetbutton1" size="medium" type="primary" @click="resetForm('addstudentForm')">清空</el-button>
            </el-form-item>
            <el-form-item>
                <el-upload
                        class="upload-demo"
                        action=""
                        :show-file-list="false"
                        :on-change="handleChange"
                        accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
                        :auto-upload="false"
                        style="display: flex;align-items: center">
                    <el-button class="batchbutton" size="medium" type="primary">批量添加</el-button>
                    <div slot="tip" class="upload-demo-tip">只能上传xlsx/xls文件</div>
                </el-upload>

            </el-form-item>
        </el-form>

        <div class="headdiv2">
            <h1 class="h1data2">信息录入</h1>
            <HR class="hrline2" align=center width=300 color=#5D998B SIZE=1></HR>
        </div>

<!--        <div class="form-group" style="display: flex">-->
<!--            <img :src="imgCode" id="img-vcode"-->
<!--                 @click="getCodeImage" alt="验证码" style="padding: 0 10px">-->
<!--            <input class="input-material" v-model="code" type="text"-->
<!--                   placeholder="输入验证码">-->
<!--        </div>-->

        <el-row class="elrowselectresult">
            <el-col :span="10" class="elcolimage">
                <el-image :src="imgCode" id="img-vcode" @click="getCodeImage" alt="验证码" style="padding: 0 10px"></el-image>
            </el-col>
            <el-col :span="1"><el-input class="input-material" v-model="code" type="text" placeholder="输入验证码"></el-input></el-col>
            <el-col :span="2"><el-button class="elbuttonselectall" @click="IdentityCodeImage()" type="primary" size="medium">搜索全部人员信息</el-button></el-col>
            <el-col :span="3"><el-input v-model="search" size="medium" placeholder="输入关键字搜索" class="elcolsearch"/></el-col>
        </el-row>



        <div>
            <el-table class="eltable1"
                      :data="tables"
                      :row-class-name="tableRowClassName"
                      :header-cell-style="{background:'#C7E2DC', 'text-align':'center'}"
                      :cell-style="{'text-align':'center'}"
                      style="width: 100%">
                <el-table-column
                        label="编号"
                        type="index"
                        width="50">
                </el-table-column>
                <el-table-column
                        prop="username"
                        label="姓名"
                        width="180">
                </el-table-column>
                <el-table-column
                        label="密码"
                        width="180">
                    <template slot-scope="scope">
                        <el-popover trigger="hover" placement="top">
                            <p>姓名: {{ scope.row.username}}</p>
                            <p>密码: {{ scope.row.password }}</p>
                            <div slot="reference" class="name-wrapper">
                                <el-tag size="medium" type="danger">{{ "敏感数据" }}</el-tag>
                            </div>
                        </el-popover>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="sno"
                        label="学号">
                </el-table-column>

                <!--            搜索-->
                <el-table-column :show-overflow-tooltip="true" header-align="left" align="left">
                    <!--                自定义返回数据位置-->
                    <!--                <template slot-scope="scope">-->
                    <!--                    {{scope.row}}-->
                    <!--                </template>-->


                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="handleEdit(scope.row)">编辑</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>

    </div>
</template>

<script>
    import axios from "axios";
    import api from '../main';
    import crypto123 from 'crypto'
    const $http = axios.create({
        baseURL: api.url,
        timeout: 1000,
        headers: {'X-Custom-Header': 'foobar'}
    });
    import { Loading } from 'element-ui';

    export default {
        name: "AddStudentnumber",
        data() {
            return {
                addstudentForm: {
                    username: '',
                    sno: '',
                    password: ''
                },
                addstudentreportcardForm: {
                    sno: '',
                    examstatus: '',
                    examgrade: '',
                    spendtime: ''
                },
                rules: {
                    username: [
                        {required: true, message: '姓名不能为空！', trigger: 'blur' }
                    ],
                    sno: [
                        {required: true, message: '学号不能为空！', trigger: 'blur' }
                    ],
                    password: [
                        {required: true, message: '密码不能为空！', trigger: 'blur' }
                    ]
                },
                imgCode: "",
                code: "",
                requestForm: "",
                tableData: [],
                search: '',
                msg: '',
                ideatitystatus: '',

                errorInfoList:[], //保存批量添加错误的用户信息
            };
        },
        created() {
            this.ideatitystatus = sessionStorage.getItem('isteacher')
            // const _this = this;
            // axios.get('http://localhost:8181/findAll').then(function (resp) {
            //     console.log(resp);
            // })
            if(this.ideatitystatus == 'teacher')
            {
                this.getCodeImage();
            }else
            {
                this.$message.error('非法的接口请求，拦截成功！');
            }
        },
        computed: {
            // 模糊搜索
            tables() {
                const search = this.search;
                if (search) {
                    // filter() 方法创建一个新的数组，新数组中的元素是通过检查指定数组中符合条件的所有元素。
                    // 注意： filter() 不会对空数组进行检测。
                    // 注意： filter() 不会改变原始数组。
                    return this.tableData.filter(data => {
                        // some() 方法用于检测数组中的元素是否满足指定条件;
                        // some() 方法会依次执行数组的每个元素：
                        // 如果有一个元素满足条件，则表达式返回true , 剩余的元素不会再执行检测;
                        // 如果没有满足条件的元素，则返回false。
                        // 注意： some() 不会对空数组进行检测。
                        // 注意： some() 不会改变原始数组。
                        return Object.keys(data).some(key => {
                            // indexOf() 返回某个指定的字符在某个字符串中首次出现的位置，如果没有找到就返回-1；
                            // 该方法对大小写敏感！所以之前需要toLowerCase()方法将所有查询到内容变为小写。
                            return String(data[key]).toLowerCase().indexOf(search) > -1
                        })
                    })
                }
                return this.tableData
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let phoneTest = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,50}$/;  //校验密码8-18位

                        if (!phoneTest.test(this.addstudentForm.password)) {
                            this.$message.error('请不要设置简单密码，密码须包含数字、字母两种元素，且密码位数为8-50位');
                            return false;
                        }else
                        {
                            // 密码MD5加密
                            const md5 = crypto123.createHash('md5');
                            md5.update(this.addstudentForm.password);
                            let aftermd5password = md5.digest('hex');
                            // this.$message.success('加密后的密码为' + aftermd5password);
                            this.addstudentForm.password = aftermd5password;
                            const _this = this;
                            axios.post(api.url + '/addstudentnumber', this.addstudentForm).then(function (resp) {
                                if(resp.data.state)
                                {
                                    _this.$message.success(resp.data.msg);
                                }else
                                {
                                    _this.$message.error(resp.data.msg);
                                }
                            });
                            this.addstudentreportcardForm.sno = this.addstudentForm.sno;
                            axios.post(api.url + '/studentreportcard/addstudentrepotcard', this.addstudentreportcardForm).then(function (resp1) {
                                if(resp1.data)
                                {
                                    _this.$message.success(resp1.data);
                                }else
                                {
                                    _this.$message.error(resp1.data);
                                }
                            });
                        }

                    } else {
                        this.$message.error("Please input correct data!")
                        return false;
                    }
                });
            },
            submitList(object) {
                            // 密码MD5加密
                            const md5 = crypto123.createHash('md5');
                            md5.update(object.password.toString());
                            let aftermd5password = md5.digest('hex');
                            // this.$message.success('加密后的密码为' + aftermd5password);
                object.password = aftermd5password;
                            const _this = this;
                            axios.post(api.url + '/addstudentnumber', object).then(function (resp) {
                                if(resp.data.state)
                                {
                                    // _this.$message.success(resp.data.msg);
                                }else
                                {
                                    // _this.$message.error(resp.data.msg);
                                    _this.errorInfoList.push(object)
                                }
                            });
                            this.addstudentreportcardForm.sno = object.sno;
                            axios.post(api.url + '/studentreportcard/addstudentrepotcard', this.addstudentreportcardForm).then(function (resp1) {
                                if(resp1.data == "学号已存在")
                                {
                                    // _this.$message.success(resp1.data);
                                }else
                                {
                                    // _this.$message.error(resp1.data);
                                }
                            });

            },
            //获取验证码
            async getCodeImage() {
                const {data: res} = await $http.get("/getImage");
                // console.log("解构前：" + res.data);
                // console.log("后端返回的base64数据：", res);
                this.imgCode = "data:image/png;base64," + res;
            },
            IdentityCodeImage() {
                const _this = this;
                // console.log(this.code);
                axios.get(api.url + '/findAll/' + this.code).then(function (resp) {
                    // console.log(resp.data);
                    if(resp.data.state)
                    {
                        _this.tableData =resp.data.list;
                        _this.getCodeImage();
                        // console.log(_this.tableData);
                    }else
                    {
                        _this.$message.error("验证码错误！");
                    }

                })
            },
            handleEdit(row) {
                // console.log(index, row);
                // this.$router.push('/messageupdate') //只用跳转直接写
                //如果需要传参数请用下面的写法
                this.$router.push({
                    path: '/userupdate',
                    //需要传递的参数
                    query: {
                        id: row.id
                    }
                })
            },
            handleDelete(row) {
                const _this = this;
                this.$confirm('此操作将永久删除该留言且不可恢复, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.delete(api.url + '/deleteByUserId/' + row.id).then(function (resp) {
                        // console.log("这是resp.data:" + resp.data);
                        // _this.msg = resp.data;
                        if(resp.data == 1)
                        {
                            _this.$message.success("删除成功！");
                        }else
                        {
                            _this.$message.error("删除数据不存在！");
                        }
                    });
                    // window.location.reload();//页面刷新
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //斑马纹代码
            tableRowClassName({row, rowIndex}) {
                let index = rowIndex + 1;
                if(index %2 == 0){
                    return 'warning-row'
                }
            },
    handleChange(file, fileList) {
        this.fileTemp = file.raw
        if (this.fileTemp) {
            if ((this.fileTemp.type == 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet') || (this.fileTemp.type == 'application/vnd.ms-excel')) {
                //读取文件获得数组对象
                this.importfxx(this.fileTemp);

            } else {
                this.$message({
                    type: 'warning',
                    message: '附件格式错误，请删除后重新上传！'
                })
            }
        } else {
            this.$message({
                type: 'warning',
                message: '请上传附件！'
            })
        }
    },
    importfxx(obj) {
        let _this = this;
        // 通过DOM取文件数据
        this.file = obj
        var rABS = false; //是否将文件读取为二进制字符串
        var f = this.file;
        var reader = new FileReader();
        //if (!FileReader.prototype.readAsBinaryString) {
        FileReader.prototype.readAsBinaryString = function (f) {
            var binary = "";
            var rABS = false; //是否将文件读取为二进制字符串
            var pt = this;
            var wb; //读取完成的数据
            var outdata;
            var reader = new FileReader();
            reader.onload = function (e) {
                var bytes = new Uint8Array(reader.result);
                var length = bytes.byteLength;
                for (var i = 0; i < length; i++) {
                    binary += String.fromCharCode(bytes[i]);
                }
                var XLSX = require('xlsx');
                if (rABS) {
                    wb = XLSX.read(btoa(fixdata(binary)), { //手动转化
                        type: 'base64'
                    });
                } else {
                    wb = XLSX.read(binary, {
                        type: 'binary'
                    });
                }
                outdata = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]);//outdata就是你想要的东西
                this.da = [...outdata]
                // let arr = []


                //显示用户等待框
                const loading = Loading.service({
                    lock: true,
                    text: '正在录入信息，请等待...',
                    spinner: 'el-icon-loading',
                    background: 'rgba(0, 0, 0, 0.7)'
                });

                this.da.map(v => {
                    let obj = {}
                    obj.username = v['姓名']
                    obj.password = v['密码']
                    obj.sno = v['学号']
                    // arr.push(obj)
                    console.log('obj');
                    console.log(obj);
                    _this.submitList(obj)
            })
                setTimeout(() => {
                    loading.close();
                    if (_this.errorInfoList.length == 0){
                        _this.$message.success("批量添加信息成功！");
                    } else{
                        _this.$message.warning("批量添加部分成功，错误信息已生成文件。");
                        _this.onClickDownDaily();
                    }
                }, 1500);
                _this.errorInfoList=[];

                /*this.$nextTick(() => { // 以服务的方式调用的 Loading 需要异步关闭
                    loading.close();
                });
*/
            }
            reader.readAsArrayBuffer(f);
        }

        if (rABS) {
            reader.readAsArrayBuffer(f);
        } else {
            reader.readAsBinaryString(f);
        }
    },
            onClickDownDaily() {
                let title = '错误信息'
                let str=''
                this.errorInfoList.forEach(item=>{
                    str+='姓名:'+item.username+'   '+'学号:'+item.sno+'\r\n'
                })
                let allStr = title+'\r\n'+'\r\n'+str
                let export_blob = new Blob([allStr]);
                let save_link = document.createElement("a");
                save_link.href = window.URL.createObjectURL(export_blob);
                save_link.download = '错误信息导出'+'.txt';
                save_link.click();
                // let element = document.getElementById("a");
                // element.parentElement.removeChild(element)
            },
    }
}
</script>


<style>
    /*.demo-table-expand {*/
    /*    font-size: 0;*/
    /*}*/
    /*.demo-table-expand label {*/
    /*    width: 90px;*/
    /*    color: #99a9bf;*/
    /*}*/
    /*.demo-table-expand .el-form-item {*/
    /*    margin-right: 0;*/
    /*    margin-bottom: 0;*/
    /*    width: 50%;*/
    /*}*/
    .h1data, .h1data2 {
        /*margin-top: -74px;*/
        margin-left: -1131px;
        font-size: 18px;
        margin-top: 32px;
        color: #445f59;
    }
    .hrline, .hrline2 {
        width: 1200px;
        margin-top: 3px;
        font-size: 18px;
        margin-bottom: 30px;
    }
    .demo-ruleForm {
        margin-left: -6%;
    }
    .batchbutton{
        margin-left: 30px;
        background-color: #239973;
    }
    .upload-demo-tip{
        margin-left: 5px;
    }
    .addbutton1, .elbuttonselectall {
        background-color: #239973;
    }
    .resetbutton1 {
        border: 1px solid #239973;
        background-color: #E9EEF3;
        color: #239973;
    }
    .eltable1 {
        width: 64%!important;
        margin: 0 auto;
        padding: 0!important;
    }
    .el-table .warning-row {
        background: #D7E4E1;
    }
    /*验证码div*/
    .form-group {
        /*margin-top: 6%!important;*/
        /*margin-left: 105%!important;*/
    }
    .elcolsearch {
        margin-left: 266%;
    }
    .elcolimage {
        width: 5.66%;
        height: 1px!important;
        margin-left: 18%;
        margin-top: 0.1%;
    }
    .elrowselectresult {
        height: 10%!important;
        margin-bottom: 14px;
    }
    .input-material {
        width: 120%;
        font-size: 1%;
        margin-left: -5px;
    }
    .elbuttonselectall {
        margin-top: 2px;
    }


</style>