(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d30d2"],{"5ab2":function(t,e,s){"use strict";s.r(e);var n=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("h1",[t._v("this is Excel Download page")]),s("table",[t._m(0),t._l(t.message,(function(e){return s("tr",[s("td",[t._v(t._s(e.id))]),s("td",[t._v(t._s(e.author))]),s("td",[t._v(t._s(e.message))]),s("td",[t._v(t._s(e.time))])])}))],2)])},a=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("tr",[s("td",[t._v("编号")]),s("td",[t._v("姓名")]),s("td",[t._v("提问内容")]),s("td",[t._v("提问时间")])])}],d={name:"message",created:function(){var t=this;axios.get("http://localhost:8181/message/findAll").then((function(e){t.message=e.data,console.log(e)}))}},o=d,c=s("2877"),i=Object(c["a"])(o,n,a,!1,null,"4d2ee93a",null);e["default"]=i.exports}}]);
//# sourceMappingURL=chunk-2d0d30d2.cd38c558.js.map