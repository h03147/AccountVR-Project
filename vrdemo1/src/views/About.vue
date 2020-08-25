<template>
  <div class="about">
    <el-row>
      <el-col class="elcol1" :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 1 : 4">
        <el-card :body-style="{ padding: '0px' }" shadow="always">
          <img src="~@/static/Trump.jpg" class="image">
          <div class="username" style="padding: -11px;">
            <span>川教授</span>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style>

.image {
  width: 100%;
  display: block;
}

.about{
  width: 55%;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
}

</style>

