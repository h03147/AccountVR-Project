<template>
    <div class='homepageswitchmaindiv'>
        <el-row class="elrowmain1">
            <el-col :span="4" class="elcol1">
                <div class="elcoldiv1" v-for="(item,index) in list"
                     :model="cur"
                     :key="item"
                     :class="{'block':true,'active':cur==index}"
                     @click="currStationChange(index, item)">
                    <div class="lefttabdiv">{{item}}</div>
                </div>
            </el-col>
            <el-col :span="12">
                <div>
                    <p class="titlep1">{{title}}</p>
                    <HR class="hrline" align=center width=300 color=#5D998B SIZE=1></HR>
                    <div class="articlediv">
<!--                        这里显示内容{{current+1}}-->
                        <div class = "divitem1" v-if="current==0">
<!--                            <h2 align="left"style="text-indent: 2em;">{{alldivForm.alldiv1.divparagra1}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra2}}</h2>-->
<!--                            <img src="~@/assets/div1to1.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra3}}</h2>-->
<!--                            <img src="~@/assets/div1to2.png"><br><br>-->
<!--                            <img src="~@/assets/div1to3.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra4}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra5}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra6}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra7}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra8}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra9}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra10}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra11}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra12}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra13}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra14}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra15}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra16}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra17}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra18}}</h2>-->
<!--                            <img src="~@/assets/div1to4.png"><br><br>-->
<!--                            <img src="~@/assets/div1to5.png"><br><br>-->
<!--                            <img src="~@/assets/div1to6.png">-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra19}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra20}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra21}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra22}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra23}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra24}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra25}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra26}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra27}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra28}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra29}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra30}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra31}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra32}}</h2>-->
<!--                            <img src="~@/assets/div1to7.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra33}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra34}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra35}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra36}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra37}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra38}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra39}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra40}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra41}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra42}}</h2>-->
<!--                            <img src="~@/assets/div1to8.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra43}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra44}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra45}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra46}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra47}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra48}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra49}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra50}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra51}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra52}}</h2>-->
<!--                            <img src="~@/assets/div1to9.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra53}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra54}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra55}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra56}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra57}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra58}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra59}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra60}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra61}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra62}}</h2>-->
<!--                            <img src="~@/assets/div1to10.png">-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra63}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra64}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra65}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra66}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra67}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra68}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra69}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra70}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra71}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra72}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra73}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra74}}</h2>-->
<!--                            <img src="~@/assets/div1to11.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra75}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra76}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra77}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra78}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra79}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra80}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra81}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra82}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra83}}</h2>-->
<!--                            <img src="~@/assets/div1to12.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra84}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra85}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra86}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra87}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra88}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra89}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra90}}</h2>-->
<!--                            <h2 align="left" >{{alldivForm.alldiv1.divparagra91}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra92}}</h2>-->
<!--                            <img src="~@/assets/div1to13.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra93}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra94}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra95}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra96}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra97}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra98}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra99}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra100}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra101}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra102}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra103}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra104}}</h2>-->
<!--                            <img src="~@/assets/div1to14.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra105}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra106}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra107}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra108}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra109}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra110}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra111}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra112}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra113}}</h2>-->
<!--                            <img src="~@/assets/div1to15.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra114}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra115}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra116}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra117}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra118}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra119}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra120}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra121}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra122}}</h2>-->
<!--                            <img src="~@/assets/div1to16.png">-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra123}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra124}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra125}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra126}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra127}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra128}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra129}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra130}}</h2>-->
<!--                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv1.divparagra131}}</h2>-->
<!--                            <img src="~@/assets/div1to17.png">-->

                            <iframe src="/OperationManual/8.html" width="876" height="19100" frameborder="0" scrolling="auto" style="position:relative;margin: 0 auto;margin-left: -11%"></iframe>

                        </div>
                        <div class = "divitem2" v-if="current==1">
                            <h2 align="left"style="text-indent: 2em">{{alldivForm.alldiv2.divparagra1}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv2.divparagra2}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv2.divparagra3}}</h2>
                            <img src="~@/assets/organization.png">

                        </div>
                        <div class = "divitem3" v-if="current==2">
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv3.divparagra1}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv3.divparagra2}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv3.divparagra3}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv3.divparagra4}}</h2>
                        </div>
                        <div class = "divitem4" v-if="current==3">
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra1}}</h1>
                            <h3 align="left" style="text-indent: 2em; font-weight: bold; font-size: 14px">{{alldivForm.alldiv4.divparagra2}}</h3>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra3}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra4}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra5}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra6}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra7}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra8}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra9}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra10}}</h1>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra11}}</h1>
                            <h3 align="left" style="text-indent: 2em; font-weight: bold; font-size: 14px">{{alldivForm.alldiv4.divparagra12}}</h3>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra13}}</h1>
                            <h3 align="left" style="text-indent: 2em ; font-weight: bold; font-size: 14px">{{alldivForm.alldiv4.divparagra14}}</h3>
                            <h1 align="left" style="text-indent: 2em">{{alldivForm.alldiv4.divparagra15}}</h1>
                        </div>
                        <div class = "divitem5" v-if="current==4">
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra1}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra2}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra3}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra4}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra5}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra6}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra7}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra8}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra9}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra10}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra11}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv5.divparagra12}}</h2>
                        </div>
                        <div class = "divitem6" v-if="current==5">
<!--                            <img src="~@/static/Trump.jpg" class="image">-->
                            <img src="~@/assets/div6gradecomment.png">
                        </div>
                        <div class = "divitem7" v-if="current==6">
                            <h3 align="left" style="text-indent: 2em; font-weight: bold; font-size: 14px">{{alldivForm.alldiv7.divparagra1}}</h3>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv7.divparagra2}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv7.divparagra3}}</h2>
                            <h3 align="left" style="text-indent: 2em; font-weight: bold; font-size: 14px">{{alldivForm.alldiv7.divparagra4}}</h3>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv7.divparagra5}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv7.divparagra6}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv7.divparagra7}}</h2>
                        </div>
                        <div class = "divitem8" v-if="current==7">
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv8.divparagra1}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv8.divparagra2}}</h2>
                            <h2 align="left" style="text-indent: 2em">{{alldivForm.alldiv8.divparagra3}}</h2>
                        </div>
                        <div class = "divitem9" v-if="current==8">
                            <video src="~@/assets/introductionvideo.mp4" controls preload="metadata" poster="~@/assets/introductionvideominiimg.png"></video>
                        </div>
                        <div class = "divitem10" v-if="current==9">
                            <video src="~@/assets/guidevideo.mp4" controls preload="metadata" poster="~@/assets/guidevideominiimg.png"></video>
                        </div>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import router from "../router";


    export default {
        name: "HomePageSwitchmenu",
        props:{

        },
        data(){
            return{
                list:[
                    "操作手册","实验背景","实验目的","试验方法","实验步骤","成绩评定","学生要求","项目应用","简介视频","引导视频"
                ],
                cur:0,
                gotopage: "",
                current: 0,
                title: "操作手册",
                alldivForm: {
                    alldiv1: {
                        divparagra1: "一．学生交互性操作步骤说明：",
                        divparagra2: "打开网址，登陆界面，进入虚拟仿真环境。点击开始实验进入实验环节。仿真环境包括：成本环境，成本核算，成本考核，成本分析，成果管理报告五个模块。",
                        divparagra3: "在右下角配有知识点讲解，知识锦囊讲解视频，记事本功能，方便学生查看辅助实验进行。",
                        divparagra4: "按照实验内容，5个模块 分为12个关键步骤。",
                        divparagra5: "(1)成本环境",
                        divparagra6: "关键步骤 1：了解公司概况和运用标准作业成本法的背景。（信息获取、制定方案步骤）",
                        divparagra7: "内容：",
                        divparagra8: "认知公司经营环境、业务及财务情况。具体包括：",
                        divparagra9: "(1)了解公司价值创造模式；",
                        divparagra10: "(2)了解公司内部的与价值创造模式匹配的组织架构、业务流程等因素基本情况；",
                        divparagra11: "(3)阅读企业财务报表，了解并分析企业整体情况；",
                        divparagra12: "阅读企业2019年度内部利润表，了解公司销售情况、销售总成本、毛利率、营业利润、息税前利润、净收入和息税折旧及摊销前利润。并初步感受成本管理现状及问题。",
                        divparagra13: "目的：",
                        divparagra14: "培养学生财务分析能力，学生能对企业的初始的总体生产经营环境和企业的经营状况有一定的了解，方便后面标准作业成本法核算实验的开展。",
                        divparagra15: "实验方法：",
                        divparagra16: "行动学习法的信息获取及制定方案步骤、观察法。",
                        divparagra17: "知识：",
                        divparagra18: "需预先掌握一定的成本管理方法，培养学生对管理会计成本管理过程中成本环境、成本环境和管理会计工具选择和应用的进一步理解。",
                        divparagra19: "(2)成本核算",
                        divparagra20: "关键步骤 2：公司作业认定。（讨论决策步骤）",
                        divparagra21: "内容：",
                        divparagra22: "企业确认每一项作业完成的工作以及执行该作业所耗费的资源费用，并据以编制作业清单。具体包括：",
                        divparagra23: "(1)了解作业认定形式是根据企业业务流程，自上而下进行分解，并和相关部门人员沟通后确定；",
                        divparagra24: "(2)熟悉作业，并对认定的作业进行分析和分类，形成作业清单；",
                        divparagra25: "(3)了解成本中心与作业归集的对应关系。",
                        divparagra26: "以作业为基础，通过成本中心的建立，依据项目动因归集项目，形成作业成本库，再依据作业动因把作业成本精确分配到最终成本对象。",
                        divparagra27: "目的：",
                        divparagra28: "培养学生业财融合能力，学生能通过对企业业务流程的了解，识别分析企业的作业，将作业按照成本中心进行归集，为标准作业成本确定提供前提。",
                        divparagra29: "实验方法：",
                        divparagra30: "行动学习法的讨论决策步骤、观察法。",
                        divparagra31: "知识：",
                        divparagra32: "需预先掌握作业成本法中作业、作业确定、资源费用、成本对象、成本动因等核心概念，并能将上述概念应用于企业实际业务。",
                        divparagra33: "关键步骤 3：制定标准作业成本（讨论决策步骤）",
                        divparagra34: "内容：",
                        divparagra35: "基于已经划分的作业，按照达成全部产能80%的比例，制定相应标准。",
                        divparagra36: "阅读标准作业成本明细，了解公司标准作业成本确定。形成作业和标准的融合概念，感受实际的应用。",
                        divparagra37: "目的：",
                        divparagra38: "培养学生成本管理过程中作业成本法、标准成本法两个管理会计工具方法融合能力，学生能在作业确定的基础上，制定标准作业成本。为标准作业成本法应用提供基础。",
                        divparagra39: "实验方法：",
                        divparagra40: "行动学习法的讨论决策步骤、观察法。",
                        divparagra41: "知识：",
                        divparagra42: "需预先掌握作业成本法、标准成本法等成本管理中应用的管理会计工具的核心概念，形成标准作业成本法的概念。",
                        divparagra43: "关键步骤 4：获取实际成本计算所需的销售订单（实施控制步骤）",
                        divparagra44: "内容：",
                        divparagra45: "销售部门通过与客户报价谈判等获得订单，学生可分析3种销售组合，选择一种，作为要生产的产品类别。",
                        divparagra46: "目的：",
                        divparagra47: "培养学生解决问题能力，使得学生通过合理选择和使用管理会计工具选择销售组合，实现实验目标，形成生产能力与生产决策、生产决策与成本管理的对应，达成业财融合效果。",
                        divparagra48: "实验方法：",
                        divparagra49: "行动学习法的实施控制步骤、控制变量法。",
                        divparagra50: "销售部门与客户的前期谈判，获得订单，并对产品价格进行协商，签合同。",
                        divparagra51: "知识：",
                        divparagra52: "生产能力利用和生产决策的关系，生产决策和成本管理的关系。能根据企业实际情况做出选择和判断。",
                        divparagra53: "关键步骤 5：实际成本核算所需的材料成本计算（实施控制步骤）",
                        divparagra54: "内容：",
                        divparagra55: "采购部根据选择的销售组合对应BOM的原材料进行采购。学生依据不同供应商的优惠条件，从3家供应商中选择成本最优化的一家。选择后通过产品的BOM确定的所需材料数量，以及每种材料的价格，最终计算出所有销售量所需的材料成本。",
                        divparagra56: "目的：",
                        divparagra57: "培养学生解决问题能力，使得学生通过合理选择和使用管理会计工具选择材料供应商，实现实验目标，形成采购决策与成本管理的对应，达成业财融合效果。",
                        divparagra58: "实验方法：",
                        divparagra59: "行动学习法的实施控制步骤、控制变量法。",
                        divparagra60: "涉及产品的报价，以及优惠力度，包括价格的年降，或者随着订单量的增加，价格降低一定的百分比。",
                        divparagra61: "知识：",
                        divparagra62: "材料采购决策与成本管理的关系。学生能够将材料采购决策与成本管理结合，能根据企业实际情况做出选择和判断。",
                        divparagra63: "关键步骤6：实际成本核算的人工和制造费用的归集（实施控制步骤）",
                        divparagra64: "内容：",
                        divparagra65: "对应所选择的销售组合的相关制造费用，将其归集到直接生产成本中心，制造费用包括直接生产线的费用，间接成本中心的费用以及管理成本中心的费用。",
                        divparagra66: "目的：",
                        divparagra67: "培养学生解决问题能力，使得学生合理使用管理会计工具实现实验目标，能根据企业实际情况实施标准作业成本法的应用程序。",
                        divparagra68: "实验方法：",
                        divparagra69: "行动学习法的讨论决策步骤、控制变量法。",
                        divparagra70: "(1) 设定每个部门的工人数量及薪酬；",
                        divparagra71: "(2) 确定满足生产需求的机器设备，确定折旧的年限；",
                        divparagra72: "(3) 收集每个部门费用。",
                        divparagra73: "知识：",
                        divparagra74: "标准作业成本法的应用。按照销售组合确定匹配的资源识别及资源费用的确认与计量、成本分配等程序进行。",
                        divparagra75: "关键步骤7：实际成本核算的实际单位人工时和机器时成本计算（实施控制步骤）",
                        divparagra76: "内容：",
                        divparagra77: "基于第六步收集的总费用，分别根据总机器时和人工时，计算实际单位人工时和机器时成本。本步骤将费用分配到单个的产品。",
                        divparagra78: "目的：",
                        divparagra79: "培养学生解决问题能力，使得学生合理使用管理会计成本管理工具中的标准作业成本法，能根据企业实际情况实施标准作业成本法的应用程序。",
                        divparagra80: "实验方法：",
                        divparagra81: "行动学习法的讨论决策步骤、控制变量法。",
                        divparagra82: "知识：",
                        divparagra83: "标准作业成本法应用程序。",
                        divparagra84: "关键步骤8：产品标准作业成本计算（实施控制步骤）",
                        divparagra85: "内容：",
                        divparagra86: "根据计算的材料成本，人工成本、机器成本，计算所选择的销售组合产品的标准作业成本。",
                        divparagra87: "目的：",
                        divparagra88: "培养学生解决问题能力，使得学生合理使用管理会计成本管理工具中的标准作业成本法，实现实验目标，能根据企业实际情况实施标准作业成本法的应用程序。",
                        divparagra89: "实验方法：",
                        divparagra90: "行动学习法的讨论决策步骤、控制变量法；",
                        divparagra91: "知识：",
                        divparagra92: "标准作业成本法应用程序。",
                        divparagra93: "关键步骤9：实际成本与标准成本计算与比较，进行成本考核（实施控制步骤）",
                        divparagra94: "内容：",
                        divparagra95: "通过比较不同成本中心实际成本与标准成本差异，实现各个成本中心的考核。",
                        divparagra96: "目的：",
                        divparagra97: "培养学生分析问题能力，使得学生合理选择和使用管理会计成本管理工具中的标准成本、作业成本核算结果与实际成本进行对比，并作出分析，实现实验目标，并根据企业实际情况继续完善成本管理方案。",
                        divparagra98: "实验方法：",
                        divparagra99: "行动学习法的讨论决策步骤、控制变量法。",
                        divparagra100: "(1)给定一个产品的实际成本值，分析与标准成本的差异，主要可从材料价钱的变化，汇率的影响，也可分析实际产品用量和标准用量的差异；",
                        divparagra101: "(2)分析差异产生的原因，提出应对措施；",
                        divparagra102: "(3)根据差异分析评价企业成本管理的恰当性。",
                        divparagra103: "知识：",
                        divparagra104: "成本考核。成本考核是对成本计划及其有关指标实际完成情况进行定期总结和评价，并根据考核结果和责任制的落实情况，进行相应奖励和惩罚，以监督和促进企业加强成本管理责任制，提高成本管理水平的成本管理活动。",
                        divparagra105: "关键步骤10：分析标准作业成本与实际成本的差异，实施成本分析（实施控制步骤）",
                        divparagra106: "内容：",
                        divparagra107: "根据第九步计算的差异值，分析成本水平与构成的变动情况，查明影响成本变动的各种因素和产生的原因，并提出有效控制成本的建议。",
                        divparagra108: "目的：",
                        divparagra109: "培养学生解决问题能力，使得学生合理选择和使用管理会计成本管理工具中的标准成本、作业成本实现实验目标，能根据企业实际情况实施成本管理方案。",
                        divparagra110: "实验方法：",
                        divparagra111: "行动学习法的讨论决策步骤、控制变量法。",
                        divparagra112: "知识：",
                        divparagra113: "成本分析。成本分析是利用成本核算提供的成本信息，分析成本水平与构成的变动情况，查明影响成本变动的各种因素和产生的原因，并提出有效措施控制成本的成本管理活动。",
                        divparagra114: "关键步骤11：实施成本管理方案及成本管理报告展示（成果展示步骤）",
                        divparagra115: "内容：",
                        divparagra116: "每个学习小组提供一份最终的学习成果，本实验学习成果是一份设计方案和研究报告。",
                        divparagra117: "目的：",
                        divparagra118: "培养学生分析问题解决问题能力，能根据企业实际情况设计和实施成本管理方案。",
                        divparagra119: "实验方法：",
                        divparagra120: "行动学习法的成果展示步骤。",
                        divparagra121: "知识：",
                        divparagra122: "成本管理报告。成本管理报告是经营层管理会计报告的一种。成本管理报告的内容包括实际成本及其差异分析，成本差异形成的原因以及改进措施等。",
                        divparagra123: "关键步骤12：查看成绩及对照参考答案总结。（总结点评步骤）",
                        divparagra124: "内容：",
                        divparagra125: "实验成绩自动批改，学生做完实验可得到一张完整的成绩单，具体展示每一得分点的分数，方便学生的自主学习。学生可以通过成绩来判断知识的掌握程度， 并有针对性的对未掌握的知识进行系统学习。",
                        divparagra126: "目的：",
                        divparagra127: "培养学生总结和反思提升管理的素质能力，能根据具体管理情况做出应变。教师可以通过数据统计分析实验项目使用情况及教学效果。",
                        divparagra128: "实验方法：",
                        divparagra129: "行动学习法的总结点评步骤。",
                        divparagra130: "知识：",
                        divparagra131: "对成本管理做出全面梳理，知识点巩固，为进入下一次循环做好准备。"
                    },
                    alldiv2: {
                        divparagra1: "公司主要生产汽车刹车片，包括乘用车，商用车以及商用车售后服务件。公司引进世界领先生产设备及工艺，主要供货给大众、奔驰、宝马、丰田、福特、斯巴鲁、保时捷等汽车制造企业。",
                        divparagra2: "目前汽车制造业在市场上分布范围广、产品具有不可替代性、更新换代快、产品种类多样化。汽车企业竞争激烈，价格不断下降，零部件随着科技的革新在加速换代。同时原材料的价格持续上涨，增加了企业获取利润的难度。如何在大环境中站稳脚跟，同时扩张市场是现阶段大部分汽车企业管理者考虑的问题。为了提升企业价值创造能力，企业全面实施精益管理，在精益管理过程中，亟需结合公司业务流程，深化成本管理，经过反复论证，M公司拟实施标准作业成本法，实现契合精益管理需求的成本管理。",
                        divparagra3: "公司包括9个部门,其中生产部包括两条生产线，每条生产线按照工序分为5个工艺，以下为公司框架图：",
                    },
                    alldiv3: {
                        divparagra1: "1.理解标准作业成本法的设计思路",
                        divparagra2: "2.掌握标准作业成本法的核算、成本考核、成分分析及成本报告",
                        divparagra3: "3.培养业财融合能力",
                        divparagra4: "4.培养管理会计工具综合应用能力"
                    },
                    alldiv4: {
                        divparagra1: "本实验采用的方法主要采用行动学习法，辅助应用观察法和控制变量法。",
                        divparagra2: "(1)行动学习法",
                        divparagra3: "贯穿OBE成果导向理念，是以学生为中心，以真实情境问题为实验项目，通过“问题—反思—总结—计划—行动—发现新问题—再反思”的循环过程中，帮助学生将行动体验上升至认知水平，再由新认知转化为有效行动。",
                        divparagra4: "行动学习过程即步骤：",
                        divparagra5: "第一，信息获取。首先，学生通过情景描述了解公司概况及业务流程等相关背景信息，明确需要解决的问题。",
                        divparagra6: "第二，制定方案。由学生根据获取的相关信息和已有的知识与经验，制定出解决问题的行动方案。",
                        divparagra7: "第三，讨论决策。学生针对行动方案进行分析、讨论，选择并确定最终行动方案。",
                        divparagra8: "第四，实施控制。学生根据确定的行动方案，按照计划逐步实施，并在过程中进行监督和控制，以达到最终解决问题的目的。",
                        divparagra9: "第五，成果展示。学生提供一份最终学习成果，本实验学习成果是一份成本管理报告。",
                        divparagra10: "第六，总结点评。",
                        divparagra11: "（备注：本步骤可以作为自主学习步骤。翻转课堂教学可以采用“自我总结+分组讨论+教师点评方式）。",
                        divparagra12: "(2)观察法",
                        divparagra13: "实验通过对生产环境和业务流程进行观察，让学生身临其境的去感受到企业的真实运营，通过对切实环境和业务的观察，逐步解决问题，做到业财融合培养。",
                        divparagra14: "(3)控制变量法",
                        divparagra15: "实验依靠控制变量法，在不同的指标中，进行数字的切换，通过对订单、供应商、价格、生产量、销售量的控制来引导整个实验，目的是让企业获得更高的效益。"
                    },
                    alldiv5: {
                        divparagra1: "1.了解公司概况和运用标准作业成本法的背景",
                        divparagra2: "2.掌握公司作业划分",
                        divparagra3: "3.制定标准成本",
                        divparagra4: "4.获取实际成本计算所需的销售订单",
                        divparagra5: "5.完成实际成本核算所需的材料成本计算",
                        divparagra6: "6.完成实际成本核算的人工和制造费用的归集",
                        divparagra7: "7.完成实际成本核算的实际单位人工时和机器时成本计算",
                        divparagra8: "8.完成产品标准作业成本计算",
                        divparagra9: "9.比较实际成本与标准成本，进行成本考核",
                        divparagra10: "10.分析标准作业成本与实际成本的差异，实施成本分析",
                        divparagra11: "11.完成成本管理报告",
                        divparagra12: "12.查看成绩及参考答案"
                    },
                    alldiv6: {
                        divparagra1: "仿真模块",
                        divparagra2: "要求",
                        divparagra3: "分数",
                        divparagra4: "评分标准",
                        divparagra5: "成本环境",
                        divparagra6: "公司概况",
                        divparagra7: "公司业务流程及作业",
                        divparagra8: "1.公司基本情况\n" +
                            "2.财务总监和小白对话讲解\n",
                        divparagra9: "根据各个部门和涉及的流程\n" +
                            "基于作业流程识别M汽车零部件制造业企业的业务选择（从给定作业中选择）\n",
                        divparagra10: "5",
                        divparagra11: "5",
                        divparagra12: "全部阅读得满分",
                        divparagra13: "5",
                        divparagra14: "5",
                        divparagra15: "全部选对5分，否则3分",
                    },
                    alldiv7: {
                        divparagra1: "(1)专业与年级要求",
                        divparagra2: "本实验项目主要面向会计学、财务管理专业本科大三、大四学生，已经从事财务会计、财务管理、管理会计从业人员。",
                        divparagra3: "市场营销、工商管理、人力资源管理、国际商务等工商管理类专业本科大三、大四学生。",
                        divparagra4: "(2)基本知识和能力要求",
                        divparagra5: "本实验所属课程《管理会计》是高校会计学专业的核心课程。需要具有会计学原理课程作为学习基础。",
                        divparagra6: "本实验是管理会计的综合实验，安排在成本管理环节理论知识授课结束后。实验共占管理会计课时中的6个课时，主要包含5个阶段，4个知识点。",
                        divparagra7: "学生可以根据“知识点”进行准备和预习，然后进行实验；掌握充分也可以跳过知识点进行实验。实验过程中遇到操作难点，可以打开“知识锦囊”，观看相关视频讲解获得需要的帮助。"
                    },
                    alldiv8: {
                        divparagra1: "1.本实验项目可以应用于《管理会计》、《成本会计》的课内综合实验，也可以应用于会计学、财务管理等工商管理类专业学生的综合实训。",
                        divparagra2: "2.本实验项目可以应用于会计学、财务管理等工商管理类专业学生实践环节的比赛。",
                        divparagra3: "3.本实验项目可以应用于制造业企业成本管理及相关内容的培训。"
                    }
                },
            }
        },
        methods: {
            currStationChange(index, val) {
                this.cur = index;
                // console.log("这是cur的值："+this.cur)
                this.current = index;
                this.title = val;
            }
        },
        created() {
            // console.log("这是cur的值："+this.cur)
        }
    }

</script>

<style scoped>
    .block{
        width:50px;
        height:50px;
        /*background-color: aqua;*/
        background-image: url("../assets/homepagedefault.png");
        background-repeat: no-repeat;

    }

    .active{
        /*background-color: brown;*/
        background-image: url("../assets/homepagetrue.png");
        background-repeat: no-repeat;
        animation: extend-width 0.5s forwards;
        color: #FFFFFF;

    }

    @keyframes extend-width {
        0%{
            width:100px;
        }
        100%{
            width:188px;
        }
    }

    .elrowmain1 {
        width: 1200px;
        margin: 0 auto;
    }
    .elcol1 {
        /*width: 16%!important;*/
    }
    .elcoldiv1 {
        width: 100%;
        margin-bottom: 5%;
        /*background-image: url("../assets/sybz1.png");*/
        /*background-repeat: no-repeat;*/
    }
    .hrline {
        width: 1200px;
        margin-top: 3px;
        margin-left: 40px;
        font-size: 18px;
        margin-bottom: 41px;
    }
    .titlep1 {
        font-size: 1vw;
        font-weight: bolder;
        margin-top: 2%;
        margin-bottom: 1%;
        margin-left: -74%;
        color: #445F59;
    }
    .homepageswitchmaindiv {
        margin-top: 20px;
    }
    .articlediv {
        margin-left: 73px;
        width: 876px;
        color: #333333;
    }
    h2, h1 {
        font-size: 0.8vw!important;
        font-weight: normal!important;
        line-height:2.8vh;
    }
    .lefttabdiv {
        padding-top: 15px;
        padding-left: 30px;
        float: left;
        font-family: Source Han Sans SC;
        font-weight: bolder;
        /*font-size: 0.8vw;*/
    }

    /*.lefttabdiv:active {*/
    /*    color: #FFFFFF;*/
    /*}*/
    /*.lefttabdiv:focus {*/
    /*    color: #FFFFFF;*/
    /*}*/
    /*.lefttabdiv:visited {*/
    /*    color: #FFFFFF;*/
    /*}*/
</style>