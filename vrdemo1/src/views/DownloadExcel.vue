<template>
    <div>
        <h1>this is Excel Download page</h1>

        <el-upload
                class="upload-demo"
                action="http://192.168.31.79:80/file/upload"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="4"
                :on-exceed="handleExceed"
                :file-list="fileList">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>

    </div>
</template>

<script>
    import api from '../main'
    export default {
        name: "message",
        data() {
            return {
                fileList: [
                    {   name: 'food.jpeg',
                        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'},
                    {
                        name: 'food2.jpeg',
                        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                    }]
            };
        },
        created() {
            const that = this
            // function upload(obj) {
            //     var formData = new FormData();
            //     formData.append("fileName", obj.file[0]);
            //
            //     $.ajax({
            //         type:"post",
            //         url:"http://localhost:8181/upload",
            //         data:formData,
            //         success:function (data) {
            //             console.log(data);
            //         }
            //     })
            // }
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

</style>