<template>
    <div>
        <div class="headdiv1">
            <h1 class="h1data">数据总览</h1>
            <HR class="hrline" align=center width=300 color=#5D998B SIZE=1></HR>
        </div>

        <div id="myEcharts4" :style="{width: '1200px', height: '432px',fontSize:'25px', margin: '0 auto', backgroundColor: 'rgba(142,244,221,0.1)'}"></div>
        <div :style="{width: '1200px', height: '135px',fontSize:'14px', position: 'relative', display: 'flex',backgroundColor: 'rgba(142,244,221,0.1)', margin: '0 auto', marginTop: '16px'}">
            <div :style="{width: '1200px', height: '215px',fontSize:'14px', position: 'relative', display: 'flex',margin: 'auto 0', marginTop: '45px'}">
                    <el-row  :gutter="4">
                        <el-col :offset="1" style="height: 15%; margin-top: -10px; margin-bottom: 10px; margin-left: -3%; color: #6F8B85; font-size: 18px">•考试概况</el-col>
                        <el-col :offset="1" style="height: 15% ">参与人数：<span style="color: #3EAD95; font-size: 18px;">{{stugotlist[0]}}人</span></el-col>
                    </el-row>
                    <el-row :gutter="4" style="margin-left: 3%">
                        <el-col :offset="1" style="height: 15%"></el-col>
                        <el-col :offset="1" style="height: 15%">完成人数：<span style="color: #3EAD95; font-size: 18px;">{{stugotlist[1]}}人</span></el-col>
                    </el-row>
                    <el-row :gutter="4" style="margin-left: 5%">
                        <el-col :offset="1" style="height: 15%"></el-col>
                        <el-col :offset="1" style="height: 15%">及格率：<span style="color: #3EAD95; font-size: 18px;">{{stugotlist[2]}}%</span></el-col>
                    </el-row>
                    <el-row  :gutter="4" style="margin-left: 5%">
                        <el-col :offset="1" style="height: 15%;"></el-col>
                        <el-col :offset="1" style="height: 15%">用时最长：<span style="color: #3EAD95; font-size: 18px;">{{stugotlist[3]}}min</span></el-col>
                    </el-row>
                    <el-row :gutter="4" style="margin-left: 5%">
                        <el-col :offset="1" style="height: 15%"></el-col>
                        <el-col :offset="1" style="height: 15%">用时最短：<span style="color: #3EAD95; font-size: 18px;">{{stugotlist[4]}}min</span></el-col>
                    </el-row>
                    <el-row :gutter="4" style="margin-left: 5%">
                        <el-col :offset="1" style="height: 15%"></el-col>
                        <el-col :offset="1" style="height: 15%">平均时长：<span style="color: #3EAD95; font-size: 18px;">{{stugotlist[5]}}min</span></el-col>
                    </el-row>


            </div>
<!--            <div id="myEcharts3" :style="{width: '300px', height: '215px',fontSize:'14px'}"></div>-->
<!--            <div id="myEcharts33" :style="{width: '300px', height: '215px',fontSize:'14px'}"></div>-->
        </div>

        <div class="headdiv2">
            <h1 class="h1data2">成绩分析</h1>
            <HR class="hrline2" align=center width=300 color=#5D998B SIZE=1></HR>
        </div>


        <div :style="{width: '1200px', height: '432px',fontSize:'14px', position: 'relative', display: 'block', margin: '0 auto', marginTop: '16px'}">

            <div :style="{width: '584px', height: '100%', position: 'relative', display: 'block', backgroundColor: 'rgba(142,244,221,0.1)', float: 'left'}">
                <div style="width: 91px; height: 17px; margin-top: 20px; margin-left: 36px; color: #6F8B85; font-size: 18px">•分数统计</div>
                <div id="myEcharts333" :style="{width: '584px', height: '400px',fontSize:'25px'}"></div>
                <div :style="{width: '500px', height: '215px',fontSize:'14px', position: 'relative', display: 'flex',margin: 'auto 0', marginTop: '-148px'}">
                    <el-row  :gutter="8" style="margin-left: -5%">
                        <el-col :offset="1" style="height: 15%; margin-left: 1%">总分：<span style="color: #3EAD95; font-size: 18px;">100分</span></el-col>
                        <el-col :offset="1" style="height: 15%">平均分：<span style="color: #3EAD95; font-size: 18px;">{{scorecounttable[0]}}分</span></el-col>
                        <el-col :offset="1" style="height: 15%; margin-left: 4%">及格分：<span style="color: #3EAD95; font-size: 18px;">{{scorecounttable[3]}}分</span></el-col>
                    </el-row>
                    <el-row :gutter="8" style="margin-left: -5%">
                        <el-col :offset="1" style="height: 15%"></el-col>
                        <el-col :offset="1" style="height: 15%; margin-left: 1%">最高分：<span style="color: #3EAD95; font-size: 18px;">{{scorecounttable[1]}}分</span></el-col>
                        <el-col :offset="1" style="height: 15%; margin-left: 6%">及格率：<span style="color: #3EAD95; font-size: 18px;">{{scorecounttable[4]}}%</span></el-col>
                    </el-row>
                    <el-row :gutter="8" style="margin-left: -5%">
                        <el-col :offset="1" style="height: 15%"></el-col>
                        <el-col :offset="1" style="height: 15%; margin-left: 50%">最低分：<span style="color: #3EAD95; font-size: 18px;">{{scorecounttable[2]}}分</span></el-col>
                        <el-col :offset="1" style="height: 15%"></el-col>
                    </el-row>
                </div>
            </div>
            <div :style="{width: '600px', height: '100%', position: 'relative', display: 'block', marginLeft: '16px', marginTop: '-20px' , float: 'right'}">
                <div :style="{width: '100%', height: '209px', position: 'relative', display: 'block', backgroundColor: 'rgba(142,244,221,0.1)'}">
                    <div style="width: 91px; height: 17px; margin-top: 20px; margin-left: 36px; color: #6F8B85; font-size: 18px">•时长统计</div>
                    <div id="myEchartsLine" :style="{width: '500px', height: '190px',fontSize:'14px', marginLeft: '60px', marginTop: '-30px'}"></div>
                </div>
                <div :style="{width: '100%', height: '207px', backgroundColor: 'rgba(142,244,221,0.1)',position: 'relative', display: 'flex', marginTop: '16px'}">
                    <div style="width: 91px; height: 17px; margin-top: 20px; margin-left: 36px; color: #6F8B85; font-size: 18px">•提交统计</div>
                    <div id="myEcharts3333" :style="{width: '350px', height: '215px',fontSize:'14px', marginLeft: '-10%'}"></div>
                </div>
            </div>

        </div>


    </div>
</template>


<script>
    import api from '../main';
    export default {
        name: "DataView",
        data() {
          return {
              totalnum: [],
              stugotlist: [],
              gradepietable: [],
              scorecounttable: [],
              timecount: [],
              submittednumbertable: []

          };
        },
        created() {
            const _this = this;
            axios.get(api.url + "/studentreportcard/studentcount/").then(response => {
                const res1 = response.data;
                console.log("请求回调的内容sturesultlist1"+res1.sturesultlist1);
                console.log("请求回调的内容sturesultlist3"+res1.sturesultlist3);
                _this.stugotlist = res1.sturesultlist1;
                _this.scorecounttable = res1.sturesultlist3;
            });

        },

        mounted() {
            //一定要注意调用顺序和div加载顺序相同，错位会导致图像不显示
            this.drawing4();
            this.drawing3();
            this.mydrawingline();
        },
        methods:{
            drawing3() {

                const _this = this;
                const myChart333 = this.echarts.init(document.getElementById('myEcharts333'));
                axios.get(api.url + "/studentreportcard/studentcount/").then(response => {
                    const res = response.data;
                    console.log("分数统计" + res.sturesultlist2);
                    _this.gradepietable = res.sturesultlist2;
                    _this.submittednumbertable = res.sturesultlist5
                    let index2 = 0;
                    const colorList2 = ['#3EAD95', '#EBA049', '#5FC1EB', '#EB5F5F', '#B75FEA'];

                    function fun2() {
                        const timer = setInterval(function() {
                            myChart333.dispatchAction({
                                type: 'hideTip',
                                seriesIndex: 0,
                                dataIndex: index2
                            });
                            // 显示提示框
                            myChart333.dispatchAction({
                                type: 'showTip',
                                seriesIndex: 0,
                                dataIndex: index2
                            });
                            // 取消高亮指定的数据图形
                            myChart333.dispatchAction({
                                type: 'downplay',
                                seriesIndex: 0,
                                dataIndex: index2 == 0? 4 : index2 -1
                            });
                            myChart333.dispatchAction({
                                type: 'highlight',
                                seriesIndex: 0,
                                dataIndex: index2
                            });
                            index2++;
                            if (index2 > 4) {
                                index2 = 0;
                            }
                        },5000)
                    };
                    fun2();
                    setTimeout(function() {fun2()}, 3000);
                    const option2 = {
                        title: {
                            text: '学生成绩分布图',
                            x: '27%',
                            y: '46%',
                            textStyle: {
                                fontSize: 12,
                                color: "#999999"
                            }
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        series: [{
                            type: 'pie',
                            center: ['35%', '30%'],
                            radius: ['14%', '26%'], //内圆半径和外圆半径占比
                            clockwise: true,
                            avoidLabelOverlap: true,
                            hoverOffset: 15,
                            itemStyle: {
                                normal: {
                                    color: function(params) {
                                        return colorList2[params.dataIndex]
                                    }
                                }
                            },
                            label: {
                                show: true,
                                position: 'outside',
                                formatter: '{a|{b}：{d}%}\n{hr|}',
                                rich: {
                                    hr: {
                                        backgroundColor: 't',
                                        borderRadius: 3,
                                        width: 2,
                                        height: 3,
                                        padding: [3, 3, 0, -12]
                                    },
                                    a: {
                                        padding: [-30, 15, -20, 15]
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    length: 8,
                                    length2: 16,
                                    lineStyle: {
                                        width: 1
                                    }
                                }
                            },
                            data: [{
                                'name': '90-100分',
                                'value': this.gradepietable[0]
                            }, {
                                'name': '80-89分',
                                'value': this.gradepietable[1]
                            }, {
                                'name': '70-79分',
                                'value': this.gradepietable[2]
                            }, {
                                'name': '60-69分',
                                'value': this.gradepietable[3]
                            }, {
                                'name': '0-59分',
                                'value': this.gradepietable[4]
                            }
                            ],
                        }],
                        //右边的显示标签
                        legend: {
                            textStyle: {
                                fontSize: 12
                            },
                            itemHeight: 10, //标签图标高度
                            itemWidth: 10,  //标签图标宽度
                            orient: "vertical",
                            left: 443,
                            top: "15%",
                            data: ["90-100分", "80-89分", "70-79分", "60-69分", "0-59分"]
                        }
                    };
                    myChart333.setOption(option2);


                    const myChart3333 = this.echarts.init(document.getElementById('myEcharts3333'));
                    let index3 = 0;
                    const colorList = ['#3EAD95', '#435F59'];
                    function fun3() {
                        const timer = setInterval(function() {
                            myChart3333.dispatchAction({
                                type: 'hideTip',
                                seriesIndex: 0,
                                dataIndex: index3
                            });
                            // 显示提示框
                            myChart3333.dispatchAction({
                                type: 'showTip',
                                seriesIndex: 0,
                                dataIndex: index3
                            });
                            // 取消高亮指定的数据图形
                            myChart3333.dispatchAction({
                                type: 'downplay',
                                seriesIndex: 0,
                                dataIndex: index3 == 0? 2 : index3 -1
                            });
                            myChart3333.dispatchAction({
                                type: 'highlight',
                                seriesIndex: 0,
                                dataIndex: index3
                            });
                            index3++;
                            if (index3 > 2) {
                                index3 = 0;
                            }
                        },3000)
                    };
                    fun3();
                    setTimeout(function() {fun3()}, 3000);
                    const option3 = {
                        title: {
                            text: Math.round((this.submittednumbertable[0]/(this.submittednumbertable[0]+this.submittednumbertable[1])) * 100) + "%",
                            x: '38%',
                            y: 'center',
                            textStyle: {
                                fontSize: 18
                            }
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        series: [{
                            type: 'pie',
                            center: ['45%', '50%'],
                            radius: ['24%', '45%'], //内圆半径和外圆半径占比
                            clockwise: true,
                            avoidLabelOverlap: true,
                            hoverOffset: 15,
                            itemStyle: {
                                normal: {
                                    color: function(params) {
                                        return colorList[params.dataIndex]
                                    }
                                }
                            },
                            label: {
                                show: true,
                                position: 'outside',
                                formatter: '{a|{b}：{c}人}\n{hr|}',
                                rich: {
                                    hr: {
                                        backgroundColor: 't',
                                        borderRadius: 3,
                                        width: 3,
                                        height: 3,
                                        padding: [3, 3, 0, -12]
                                    },
                                    a: {
                                        padding: [-30, 15, -20, 15]
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    length: 8,
                                    length2: 16,
                                    lineStyle: {
                                        width: 1
                                    }
                                }
                            },
                            data: [{
                                'name': '已提交',
                                'value': this.submittednumbertable[0]
                            }, {
                                'name': '未提交',
                                'value': this.submittednumbertable[1]
                            }
                            ],
                        }],
                        legend: {
                            orient: "vertical",
                            left: "75%",
                            top: "25%",
                            data: ["已提交", "未提交"],
                            itemHeight: 15,
                            itemWidth: 15
                        }
                    };
                    myChart3333.setOption(option3);

                });










            },
            drawing4() {

                const myChart4 = this.echarts.init(document.getElementById('myEcharts4'));
                axios.get(api.url + "/statistics/findAll/").then(response => {
                    let res = response.data;
                    let visitornumber = [];
                    let month = [];
                    for (let i = 0; i < res.length; i++)
                    {
                        visitornumber.push(res[i].visitornumber);
                        month.push(res[i].year+"/"+res[i].month);
                    }
                    // console.log(month);
                    const option = {
                        title: {
                            text: '·访问统计',
                            textStyle: {
                                color: '#6F8B85'
                            }
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            // data: ['2018', '2019']
                            data: ['2020']
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '5%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,//坐标轴两边留白
                            data: month,
                            axisLabel: { //坐标轴刻度标签的相关设置。
                                interval: 0,//设置为 1，表示『隔一个标签显示一个标签』
                                // margin:15,
                                textStyle: {
                                    color: '#3D3D3D',
                                    fontStyle: 'normal',
                                    fontFamily: '微软雅黑',
                                    fontSize: 12,
                                },
                                formatter:function(params) {
                                    let newParamsName = "";
                                    let paramsNameNumber = params.length;
                                    let provideNumber = 7;  //一行显示几个字
                                    let rowNumber = Math.ceil(paramsNameNumber / provideNumber);
                                    if (paramsNameNumber > provideNumber) {
                                        for (let p = 0; p < rowNumber; p++) {
                                            let tempStr = "";
                                            let start = p * provideNumber;
                                            let end = start + provideNumber;
                                            if (p == rowNumber - 1) {
                                                tempStr = params.substring(start, paramsNameNumber);
                                            } else {
                                                tempStr = params.substring(start, end) + "\n";
                                            }
                                            newParamsName += tempStr;
                                        }

                                    } else {
                                        newParamsName = params;
                                    }
                                    return newParamsName
                                },
                                //rotate:50,
                            },
                            axisTick:{//坐标轴刻度相关设置。
                                show: false,
                            },
                            axisLine:{//坐标轴轴线相关设置
                                lineStyle:{
                                    color:'#7EA59E', //x轴轴线颜色
                                    // opacity:0.2
                                }
                            },
                            splitLine: { //坐标轴在 grid 区域中的分隔线。
                                show: true,
                                lineStyle: {
                                    color: '#E5E9ED',
                                    // 	opacity:0.1
                                }
                            }
                        },
                        yAxis: [
                            {
                                type: 'value',
                                splitNumber: 4, //y轴坐标轴上数字间隔个数
                                axisLabel: {
                                    textStyle: {
                                        color: '#3D3D3D',
                                        fontStyle: 'normal',
                                        fontFamily: '微软雅黑',
                                        fontSize: 12,
                                    }
                                },
                                axisLine:{
                                    lineStyle:{
                                        color:'#7EA59E', //y轴轴线颜色
                                        // opacity:0.2
                                    }
                                },
                                axisTick:{
                                    show: false
                                },
                                splitLine: {
                                    show: true,
                                    lineStyle: {
                                        color: '#E5E9ED',
                                        // 	opacity:0.1
                                    }
                                }

                            }
                        ],
                        series: [
                            {
                                name: '2020',
                                type: 'line',
                                showSymbol: false, //是否显示折点圆圈，如果 false 则只有在 tooltip hover 鼠标悬浮的时候显示
                                itemStyle: {
                                    normal: {
                                        color:'#239973', //线上面折点颜色
                                        lineStyle: {
                                            color: "#239973",//折线的颜色
                                            width:2
                                        },
                                        areaStyle: {
                                            color: new this.echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                                                offset: 0,
                                                color: 'rgba(35,153,115,0)' //线下面的渐变色
                                            }, {
                                                offset: 1,
                                                color: 'rgba(35,153,115,0.35)'
                                            }]),
                                        }
                                    }
                                },
                                stack: '总量',
                                // data: [ 1010, 2222, 3152, 3666, 500, 6777, 5266, 3333, 6654, 5525, 565, 455]
                                data: visitornumber
                            },
                            // {
                            //     name: '2019',
                            //     type: 'line',
                            //     itemStyle: {
                            //         normal: {
                            //             color:'rgba(255,80,124,1)',
                            //             lineStyle: {
                            //                 color: "rgba(255,80,124,1)",
                            //                 width:1
                            //             },
                            //             areaStyle: {
                            //                 color: new this.echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                            //                     offset: 0,
                            //                     color: 'rgba(255,80,124,0)'
                            //                 }, {
                            //                     offset: 1,
                            //                     color: 'rgba(255,80,124,0.35)'
                            //                 }]),
                            //             }
                            //         }
                            //     },
                            //     data: [9, 5,7,8,6,7,8,7,7,6,8,6]
                            // }
                        ]
                    };
                    myChart4.setOption(option);

                })

            },
            mydrawingline() {
                const _this = this;
                const myEChartsLine = this.echarts.init(document.getElementById('myEchartsLine'));
                axios.get(api.url + "/studentreportcard/studentcount/").then(response => {
                    const res2 = response.data;
                    console.log("请求回调的内容sturesultlist4"+res2.sturesultlist4);
                    _this.timecount = res2.sturesultlist4;
                    const yData = ['平均时长', '总时长'];
                    const dataArr = _this.timecount;
                    const colorList3 = ['#EBA149', '#3DAD95'];


                    const option = {
                        // backgroundColor: 'rgba(141,243,221,0.1)',
                        tooltip: {
                            trigger: 'axis',
                            padding: [10, 10],
                            axisPointer: {
                                type: 'shadow'
                            },
                            formatter: function (param) {
                                return param[0].name + "：" + param[0].value
                            }
                        },
                        grid: {
                            left: 60,
                            right: 48,
                            top: 60,
                            bottom: 0,
                            width: "65%", // 宽度
                            height: "60%"// 高度
                        },
                        xAxis: {
                            type: 'value',
                            axisLabel: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            splitLine: {
                                show: false
                            }
                        },
                        yAxis: [{
                            type: 'category',
                            data: yData,
                            axisLabel: {
                                color: "#333333",
                                fontSize: 12
                            },
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: '#7DA59D', //y轴轴线颜色
                                }
                            }
                        }, {
                            type: 'category',
                            axisTick: 'none',
                            axisLine: 'none',
                            show: true,
                            axisLabel: {
                                textStyle: {
                                    color: '#3DAD95',
                                    fontSize: 14
                                }
                            },
                            data: dataArr
                        }],
                        series: [{
                            name: '',
                            type: 'bar',
                            data: dataArr,
                            barWidth: 24,
                            zlevel: 1,
                            // itemStyle: {
                            //     normal: {
                            //         color: function(params) {
                            //             return colorList3[params.dataIndex]
                            //         }
                            //     }
                            // }
                            itemStyle: {
                                normal: {
                                    color: function (params) {
                                        return colorList3[params.dataIndex]
                                    }
                                }
                            },
                        }]
                    };

                    myEChartsLine.setOption(option);
                });

            }

        }
    }

</script>

<style scoped>
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
    .table1 {
        height: 50px;
    }

</style>