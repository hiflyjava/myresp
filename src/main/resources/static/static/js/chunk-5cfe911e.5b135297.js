(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5cfe911e"],{"73bd":function(e,t,a){"use strict";var l=a("c104"),n=a.n(l);n.a},c104:function(e,t,a){},fe8e:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"register"}},[a("div",{staticClass:"change_pwd"},[a("h2",[e._v("REGISTERED")]),a("div",{staticClass:"form_pwd"},[e._m(0),e._m(1),a("div",{staticClass:"form"},[a("el-select",{staticClass:"prefix",attrs:{placeholder:"select"},model:{value:e.prefixValue,callback:function(t){e.prefixValue=t},expression:"prefixValue"}},e._l(e.options,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1),a("input",{staticClass:"phone",attrs:{type:"text",placeholder:"Enter phone"}})],1),e._m(2),e._m(3),e._m(4)]),a("div",{staticClass:"nextBtn"},[a("div",[a("button",{on:{click:e.nextAction}},[e._v("NEXT STEP")])]),a("div",{staticClass:"allow"},[a("el-checkbox",{model:{value:e.allowChecked,callback:function(t){e.allowChecked=t},expression:"allowChecked"}},[e._v("Read and agree to the Terms of Use and Privacy Policy")])],1)])])])},n=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"name form"},[a("input",{attrs:{type:"text",placeholder:"Name"}})])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"surname form"},[a("input",{attrs:{type:"text",placeholder:"Surname"}})])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"pwd_new form"},[a("input",{attrs:{type:"text",placeholder:"Reset password"}})])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"pwd_again form"},[a("input",{attrs:{type:"text",placeholder:"Enter your password again"}})])},function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"code form"},[a("input",{staticClass:"codeInp",attrs:{type:"text",placeholder:"Enter confirmation code"}}),a("button",[e._v("RESEND")])])}],s={data:function(){return{options:[{value:"选项1",label:"+1"},{value:"选项2",label:"+86"},{value:"选项3",label:"+3"}],prefixValue:"",allowChecked:!1}},methods:{nextAction:function(){this.$router.push({name:"login"})}}},r=s,c=(a("73bd"),a("2877")),i=Object(c["a"])(r,l,n,!1,null,null,null);t["default"]=i.exports}}]);