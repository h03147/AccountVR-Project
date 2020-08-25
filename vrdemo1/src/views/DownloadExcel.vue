<template>
    <div>
        <h1>this is Excel Download page</h1>
        <table>
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>提问内容</td>
                <td>提问时间</td>
            </tr>
            <tr v-for="item in message">
                <td>{{item.id}}</td>
                <td>{{item.author}}</td>
                <td>{{item.message}}</td>
                <td>{{item.time}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        name: "message",
        created() {
            const that = this
            axios.get('http://localhost:8181/message/findAll').then(function (resp) {
                that.message = resp.data
                console.log(resp);
            })
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
        }
    }
</script>

<style scoped>

</style>