<template>
    <div>
        <h1>this is Excel Download page</h1>
        <el-upload
                class="upload-demo"
                action="http://192.168.31.79:8083/test/import"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="4"
                :on-exceed="handleExceed"
                :file-list="fileList">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传excel文件，且不超过5MB</div>
        </el-upload>
    </div>

</template>

<script>
    /* eslint-disable */
    export default {
        name: "BatchAddStudent",
        data() {
            return {
                fileList: []
            };
        },
        methods: {
            handleRemove(file, fileList) {
                // console.log(file, fileList);
            },
            handlePreview(file) {
                // console.log(file);
            },
            handleExceed(files, fileList) {
                this.$message.warning(`当前限制选择 4 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
            },
            beforeRemove(file, fileList) {
                return this.$confirm(`确定移除 ${ file.name }？`);
            }
        }

    }
</script>

<style scoped>
    /*引入excel插件样式*/
    /*@import "../../static/css/gc.spread.sheets.13.1.4.css";*/

</style>