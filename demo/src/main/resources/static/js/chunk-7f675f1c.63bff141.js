(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7f675f1c"],{"386d":function(e,s,t){},cb39:function(e,s,t){"use strict";t.r(s);var a=function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("div",[t("el-form",{ref:"addmessageForm",staticClass:"demo-ruleForm",attrs:{inline:!0,model:e.addmessageForm,rules:e.rules,"label-width":"80px"}},[t("iframe",{staticStyle:{position:"relative",margin:"0 auto"},attrs:{src:"/Acc/index.html",width:"1200",height:"700",frameborder:"0",scrolling:"auto"}}),t("el-form-item",{staticClass:"elformitem1",attrs:{label:"问题描述",prop:"question"}},[t("el-input",{staticClass:"elinput1",attrs:{type:"textarea",placeholder:"Please describe your question(NOT NULL)",maxlength:"49","show-word-limit":""},model:{value:e.addmessageForm.question,callback:function(s){e.$set(e.addmessageForm,"question",s)},expression:"addmessageForm.question"}})],1),t("el-form-item",{staticClass:"elformitem2"},[t("el-button",{staticClass:"elbtn1",attrs:{size:"small",type:"primary"},on:{click:function(s){return e.submitForm("addmessageForm")}}},[e._v("提交问题")])],1)],1)],1)},r=[],o=t("56d7"),i={data:function(){return{addmessageForm:{student_name:"",question:""},rules:{question:[{required:!0,message:"提问内容不能为空",trigger:"blur"}]}}},methods:{submitForm:function(e){var s=this;this.$refs[e].validate((function(e){if(!e)return s.$message.error("add message failed"),!1;s.addmessageForm.student_name=sessionStorage.getItem("token");var t=s;axios.post(o["default"].url+"/message/addmessage",s.addmessageForm).then((function(e){console.log(e.data),t.$message.success(e.data),t.addmessageForm.question=""}))}))}}},n=i,m=(t("cebe"),t("2877")),l=Object(m["a"])(n,a,r,!1,null,"5ffaccc5",null);s["default"]=l.exports},cebe:function(e,s,t){"use strict";var a=t("386d"),r=t.n(a);r.a}}]);
//# sourceMappingURL=chunk-7f675f1c.63bff141.js.map