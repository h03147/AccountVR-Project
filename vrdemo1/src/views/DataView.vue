<template>
    <div>
        <div>
            <h1 class="h1data">数据总览</h1>
            <HR class="hrline" align=center width=300 color=#987cb9 SIZE=1></HR>
        </div>

        <div id="myEcharts4" :style="{width: '1123px', height: '432px',fontSize:'25px', margin: '0 auto'}"></div>
        <div :style="{width: '1200px', height: '215px',fontSize:'14px', position: 'relative', display: 'flex', backgroundColor: 'gray', margin: '0 auto'}">
            <div :style="{width: '500px', height: '215px',fontSize:'14px', backgroundColor: '#fff' , position: 'relative', display: 'flex'}">
<!--                <div>考试场次：</div><div>完成进度：</div><div>-&#45;&#45;：</div>-->
<!--                <div>参与人数：</div><div>完成人数：</div><div>及格率：</div>-->
<!--                <div>用时最长：</div><div>用时最短</div><div>平均时长：</div>-->
<!--                <table class="table1">-->
<!--                <tr>-->
<!--                    <th>&nbsp;1</th>-->
<!--                    <th>&nbsp;2</th>-->
<!--                    <th>&nbsp;3</th>-->
<!--                </tr>-->
<!--                <tr>-->
<!--                    <td>&nbsp;4</td>-->
<!--                    <td>&nbsp;5</td>-->
<!--                    <td>&nbsp;6</td>-->
<!--                </tr>-->
<!--                <tr>-->
<!--                    <td>&nbsp;7</td>-->
<!--                    <td>&nbsp;8</td>-->
<!--                    <td>&nbsp;9</td>-->
<!--                </tr>-->
<!--                </table>-->

                <el-row  :gutter="10">
                    <el-col :offset="1" style="height: 15%">考试场次：</el-col>
                    <el-col :offset="1" style="height: 15%">参与人数：</el-col>
                    <el-col :offset="1" style="height: 15%">用时最长：</el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :offset="1" style="height: 15%">完成进度：</el-col>
                    <el-col :offset="1" style="height: 15%">完成人数：</el-col>
                    <el-col :offset="1" style="height: 15%">用时最短：</el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :offset="1" style="height: 15%">----</el-col>
                    <el-col :offset="1" style="height: 15%">及格率：</el-col>
                    <el-col :offset="1" style="height: 15%">平均时长：</el-col>
                </el-row>

            </div>
            <div id="myEcharts3" :style="{width: '300px', height: '215px',fontSize:'14px'}"></div>
            <div id="myEcharts33" :style="{width: '300px', height: '215px',fontSize:'14px'}"></div>
        </div>
        <div id="myEcharts2" :style="{width: '400px', height: '400px',fontSize:'25px'}"></div>

        <div id="myEcharts" :style="{width: '400px', height: '400px',fontSize:'25px'}"></div>

    </div>
</template>


<script>
    export default {
        name: "DataView",
        data() {
          return {


          };
        },

        mounted() {
            //一定要注意调用顺序和div加载顺序相同，错位会导致图像不显示
            this.drawing4();
            this.drawing3();
            this.drawing();
            this.drawing2();
        },
        methods:{
            drawing() {
                this.echarts.init(document.getElementById('myEcharts')).setOption({
                    series: {
                        type: 'pie',
                        data: [
                            {name: '故障', value: 1},
                            {name: '正常', value: 2},
                        ],
                        center: ['50%', '50%'],
                        grid:{left:'3%',right:'3%',bottom:'10%', containLabel:true},
                        itemStyle:{normal:{label:{
                                    show: true, formatter: '{b}',textStyle:{fontSize : 16}
                                },color:function (params) {
                                    const colorList = [
                                        'red','#0bd687'
                                    ];
                                    return colorList[params.dataIndex]
                                }
                            }}
                    }
                });
            },
            drawing2() {
                // 基于准备好的dom，初始化echarts实例
                const myChart = this.echarts.init(document.getElementById('myEcharts2'));

                // 指定图表的配置项和数据
                const option = {
                    title: {
                        text: 'ECharts 入门示例'
                    },
                    tooltip: {},
                    legend: {
                        data:['销量']
                    },
                    xAxis: {
                        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                    },
                    yAxis: {},
                    series: [{
                        name: '销量',
                        type: 'bar',
                        data: [5, 20, 36, 10, 10, 20]
                    }]
                };

                // 把option配置和dom绑定
                myChart.setOption(option);
            },
            drawing3() {
                const myChart3 = this.echarts.init(document.getElementById('myEcharts3'));
                const myChart33 = this.echarts.init(document.getElementById('myEcharts33'));
                let index = 0;
                const colorList = ['#73DDFF', '#73ACFF', '#FDD56A', '#FDB36A', '#FD866A', '#9E87FF', '#58D5FF'];
                function fun() {
                    const timer = setInterval(function() {
                        myChart3.dispatchAction({
                            type: 'hideTip',
                            seriesIndex: 0,
                            dataIndex: index
                        });
                        // 显示提示框
                        myChart3.dispatchAction({
                            type: 'showTip',
                            seriesIndex: 0,
                            dataIndex: index
                        });
                        // 取消高亮指定的数据图形
                        myChart3.dispatchAction({
                            type: 'downplay',
                            seriesIndex: 0,
                            dataIndex: index == 0? 5 : index -1
                        });
                        myChart3.dispatchAction({
                            type: 'highlight',
                            seriesIndex: 0,
                            dataIndex: index
                        });
                        index++;
                        if (index > 5) {
                            index = 0;
                        }
                    },3000)
                };
                fun();
                setTimeout(function() {fun()}, 5000);
                const option = {
                    title: {
                        text: 'pieChart',
                        x: 'center',
                        y: 'center',
                        textStyle: {
                            fontSize: 20
                        }
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    series: [{
                        type: 'pie',
                        center: ['50%', '50%'],
                        radius: ['24%', '45%'],
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
                            formatter: '{a|{b}：{d}%}\n{hr|}',
                            rich: {
                                hr: {
                                    /*
                            再次声明一下，大家在这里修改之后不要点击上面的保存！
                    不要点击保存！不要点击保存！重要的事情说三遍！
                    你的修改会覆盖我的原代码的！感谢理解！
                                                --2020/8/4  by--suwanqing
                                    */
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
                                length: 20,
                                length2: 30,
                                lineStyle: {
                                    width: 1
                                }
                            }
                        },
                        data: [{
                            'name': '一月',
                            'value': 1.45
                        }, {
                            'name': '二月',
                            'value': 2.93
                        }, {
                            'name': '三月',
                            'value': 3.15
                        }, {
                            'name': '四月',
                            'value': 4.78
                        }, {
                            'name': '五月',
                            'value': 5.93
                        }, {
                            'name': '六月',
                            'value': 5.73
                        }
                        ],
                    }]
                };

                myChart3.setOption(option);
                myChart33.setOption(option);



            },
            drawing4() {
                const myChart4 = this.echarts.init(document.getElementById('myEcharts4'));
                const option = {
                    title: {
                        text: '·访问统计'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['2018', '2019']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
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
                        data: ['12201', '12202', '12203','12204','12301','12302','12303','12304','12401', '12402', '12403','12404'],
                        axisLabel: { //坐标轴刻度标签的相关设置。
                            interval: 0,//设置为 1，表示『隔一个标签显示一个标签』
                            //	margin:15,
                            textStyle: {
                                color: '#1B253A',
                                fontStyle: 'normal',
                                fontFamily: '微软雅黑',
                                fontSize: 12,
                            },
                            formatter:function(params) {
                                let newParamsName = "";
                                let paramsNameNumber = params.length;
                                let provideNumber = 4;  //一行显示几个字
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
                                color:'#E5E9ED',
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
                            splitNumber: 5,
                            axisLabel: {
                                textStyle: {
                                    color: '#a8aab0',
                                    fontStyle: 'normal',
                                    fontFamily: '微软雅黑',
                                    fontSize: 12,
                                }
                            },
                            axisLine:{
                                show: false
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
                            name: '2018',
                            type: 'line',
                            itemStyle: {
                                normal: {
                                    color:'#3A84FF',
                                    lineStyle: {
                                        color: "#3A84FF",
                                        width:1
                                    },
                                    areaStyle: {
                                        color: new this.echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                                            offset: 0,
                                            color: 'rgba(58,132,255,0)'
                                        }, {
                                            offset: 1,
                                            color: 'rgba(58,132,255,0.35)'
                                        }]),
                                    }
                                }
                            },
                            data: [ 1, 2, 3, 3, 5, 6, 5, 3, 6, 5, 5, 4]
                        },
                        {
                            name: '2019',
                            type: 'line',
                            itemStyle: {
                                normal: {
                                    color:'rgba(255,80,124,1)',
                                    lineStyle: {
                                        color: "rgba(255,80,124,1)",
                                        width:1
                                    },
                                    areaStyle: {
                                        color: new this.echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                                            offset: 0,
                                            color: 'rgba(255,80,124,0)'
                                        }, {
                                            offset: 1,
                                            color: 'rgba(255,80,124,0.35)'
                                        }]),
                                    }
                                }
                            },
                            data: [9, 5,7,8,6,7,8,7,7,6,8,6]
                        }
                    ]
                };
                myChart4.setOption(option);
            }

        }
    }

</script>

<style scoped>
    .h1data {
        margin-top: -74px;
        margin-left: -1099px;
        font-size: 18px;
    }
    .hrline {
        width: 1200px;
        margin-top: -79px;
        font-size: 18px;
    }
    .table1 {
        height: 50px;
    }

</style>