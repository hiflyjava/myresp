(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-10a2855e"],{3275:function(t,e,s){"use strict";s.r(e);var o=function(){var t=this,e=t.$createElement,s=t._self._c||e;return t.showTags?s("div",{staticClass:"tags"},[s("ul",t._l(t.tagsList,function(e,o){return s("li",{key:o,staticClass:"tags-li",class:{active:t.isActive(e.path)}},[s("router-link",{staticClass:"tags-li-title",attrs:{to:e.path}},[t._v("\n                "+t._s(e.title)+"\n            ")]),s("span",{staticClass:"tags-li-icon",on:{click:function(e){t.closeTags(o)}}},[s("i",{staticClass:"el-icon-close"})])],1)}),0),s("div",{staticClass:"tags-close-box"},[s("el-dropdown",{on:{command:t.handleTags}},[s("el-button",{attrs:{size:"mini",type:"primary"}},[t._v("\n                标签选项"),s("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),s("el-dropdown-menu",{attrs:{slot:"dropdown",size:"small"},slot:"dropdown"},[s("el-dropdown-item",{attrs:{command:"other"}},[t._v("关闭其他")]),s("el-dropdown-item",{attrs:{command:"all"}},[t._v("关闭所有")])],1)],1)],1)]):t._e()},n=[],a=(s("7f7f"),s("7ed4")),i={data:function(){return{tagsList:[]}},methods:{isActive:function(t){return t===this.$route.fullPath},closeTags:function(t){var e=this.tagsList.splice(t,1)[0],s=this.tagsList[t]?this.tagsList[t]:this.tagsList[t-1];s?e.path===this.$route.fullPath&&this.$router.push(s.path):this.$router.push("/")},closeAll:function(){this.tagsList=[],this.$router.push("/")},closeOther:function(){var t=this,e=this.tagsList.filter(function(e){return e.path===t.$route.fullPath});this.tagsList=e},setTags:function(t){var e=this.tagsList.some(function(e){return e.path===t.fullPath});e||(this.tagsList.length>=8&&this.tagsList.shift(),this.tagsList.push({title:t.meta.title,path:t.fullPath,name:t.matched[1].components.default.name})),a["a"].$emit("tags",this.tagsList)},handleTags:function(t){"other"===t?this.closeOther():this.closeAll()}},computed:{showTags:function(){return this.tagsList.length>0}},watch:{$route:function(t,e){this.setTags(t)}},created:function(){var t=this;this.setTags(this.$route),a["a"].$on("close_current_tags",function(){for(var e=0,s=t.tagsList.length;e<s;e++){var o=t.tagsList[e];o.path===t.$route.fullPath&&(e<s-1?t.$router.push(t.tagsList[e+1].path):e>0?t.$router.push(t.tagsList[e-1].path):t.$router.push("/"),t.tagsList.splice(e,1))}})}},r=i,l=(s("c5f3"),s("2877")),c=Object(l["a"])(r,o,n,!1,null,null,null);e["default"]=c.exports},3785:function(t,e,s){},"57da":function(t,e,s){"use strict";s.r(e);var o=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"wrapper"},[s("v-head"),s("sidebar"),s("div",{staticClass:"content-box",class:{"content-collapse":t.collapse},attrs:{id:"content"}},[s("div",{staticClass:"tags"},[s("el-breadcrumb",{staticStyle:{"margin-top":"8px","margin-left":"10px"},attrs:{separator:"/"}},[s("el-breadcrumb-item",{directives:[{name:"show",rawName:"v-show",value:"Home"==this.$router.currentRoute.matched[0].name&&("en"==this.language||""==this.language)&&("Add Staff"==this.$router.currentRoute.name||"Edit Staff"==this.$router.currentRoute.name),expression:"this.$router.currentRoute.matched[0].name == 'Home' && (this.language == 'en' || this.language == '') && (this.$router.currentRoute.name == 'Add Staff' || this.$router.currentRoute.name == 'Edit Staff')"}]},[t._v("Staff Management")]),s("el-breadcrumb-item",{directives:[{name:"show",rawName:"v-show",value:"Home"==this.$router.currentRoute.matched[0].name&&"zhCHS"==this.language&&("Add Staff"==this.$router.currentRoute.name||"Edit Staff"==this.$router.currentRoute.name),expression:"this.$router.currentRoute.matched[0].name == 'Home' && (this.language == 'zhCHS') && (this.$router.currentRoute.name == 'Add Staff' || this.$router.currentRoute.name == 'Edit Staff')"}]},[t._v("人员管理")]),s("el-breadcrumb-item",{directives:[{name:"show",rawName:"v-show",value:"Home"!=this.$router.currentRoute.matched[0].name||"Dashboard"==this.$router.currentRoute.name,expression:"this.$router.currentRoute.matched[0].name != 'Home' || this.$router.currentRoute.name == 'Dashboard'"}]},[t._v(t._s(this.$router.currentRoute.matched[0].name))]),s("el-breadcrumb-item",{directives:[{name:"show",rawName:"v-show",value:"Home"==this.$router.currentRoute.matched[0].name&&("availabillty"==this.$router.currentRoute.name||"guest"==this.$router.currentRoute.name||"checkinmessage"==this.$router.currentRoute.name||"select room"==this.$router.currentRoute.name||"reply"==this.$router.currentRoute.name),expression:"this.$router.currentRoute.matched[0].name == 'Home' && (this.$router.currentRoute.name == 'availabillty' || this.$router.currentRoute.name == 'guest' || this.$router.currentRoute.name == 'checkinmessage' || this.$router.currentRoute.name == 'select room' || this.$router.currentRoute.name == 'reply')"}]},[t._v("Create New Reservation")]),"Reservations"==this.$router.currentRoute.name?s("el-breadcrumb-item",{domProps:{textContent:t._s(t.name)}}):t._e(),"Reservations"!=this.$router.currentRoute.name&&"availabillty"!=this.$router.currentRoute.name&&"guest"!=this.$router.currentRoute.name&&"checkinmessage"!=this.$router.currentRoute.name&&"select room"!=this.$router.currentRoute.name&&"reply"!=this.$router.currentRoute.name&&"Reservations"!=this.$router.currentRoute.name?s("el-breadcrumb-item",{domProps:{textContent:t._s(this.$router.currentRoute.name)}}):t._e()],1)],1),s("div",{staticClass:"content"},[s("transition",{attrs:{name:"fade","enter-to-class":"fadeOut animated","leave-to-class":"fadeOut animated",duration:{enter:600,leave:600}}},[s("router-view")],1)],1)])],1)},n=[],a=(s("7f7f"),s("cff1")),i=s("a315"),r=s("3275"),l=s("7ed4"),c={data:function(){return{tagsList:[],collapse:!1,name:"List",lang:"en",language:window.localStorage.getItem("lang")}},computed:{routeName:function(){return this.$router.currentRoute.name}},components:{"v-head":a["default"],sidebar:i["default"],tags:r["default"]},created:function(){var t=this;l["a"].$on("collapse",function(e){t.collapse=e}),l["a"].$on("tags",function(e){for(var s=[],o=0,n=e.length;o<n;o++)e[o].name&&s.push(e[o].name);t.tagsList=s})},watch:{$route:function(t,e){console.log(t.path,this.$router.currentRoute.name),l["a"].$emit("selectHotel",this.$router.currentRoute.name)}}},u=c,m=(s("dbc2"),s("2877")),h=Object(m["a"])(u,o,n,!1,null,null,null);e["default"]=h.exports},"5ebe":function(t,e,s){},7159:function(t,e,s){t.exports=s.p+"static/img/img.146655c9.jpg"},a315:function(t,e,s){"use strict";s.r(e);var o=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"sidebar"},[s("el-menu",{staticClass:"sidebar-el-menu",attrs:{collapse:t.collapse,router:""}},[t._l(this.routes,function(e,o){return[e.children?[s("el-submenu",{key:o,attrs:{index:o+""}},[s("template",{slot:"title"},[s("i",{class:e.iconcls}),s("span",{attrs:{slot:"title"},slot:"title"},[t._v(t._s(e.name))])]),t._l(e.children,function(e){return[s("el-menu-item",{key:e.path,attrs:{index:e.path}},[t._v("\n                            "+t._s(e.name)+"\n                        ")])]})],2)]:[s("el-menu-item",{key:e.index,attrs:{index:e.path}},[s("i",{class:t.iconcls[o]}),s("span",{attrs:{slot:"title"},slot:"title"},[t._v(t._s(e.name))])])]]})],2)],1)},n=[],a=(s("cadf"),s("551c"),s("097d"),s("7ed4")),i={data:function(){return{collapse:!1,menu:"",iconcls:["el-icon-lx-home","el-icon-lx-news","el-icon-lx-text","el-icon-time","el-icon-lx-people","el-icon-setting"]}},computed:{routes:function(){return this.$store.state.routes}},methods:{},created:function(){var t=this;a["a"].$on("collapse",function(e){t.collapse=e})}},r=i,l=(s("be3e"),s("2877")),c=Object(l["a"])(r,o,n,!1,null,null,null);e["default"]=c.exports},a66a:function(t,e,s){},be3e:function(t,e,s){"use strict";var o=s("a66a"),n=s.n(o);n.a},c5f3:function(t,e,s){"use strict";var o=s("5ebe"),n=s.n(o);n.a},cff1:function(t,e,s){"use strict";s.r(e);var o,n=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"header"},[s("div",{staticClass:"collapse-btn",on:{click:t.collapseChage}},[s("i",{staticClass:"el-icon-menu"})]),s("div",{staticClass:"logo"},[t._v(t._s(t.$t("header.title")))]),s("div",{staticClass:"header-right"},[s("div",{staticClass:"header-user-con"},[s("div",{directives:[{name:"show",rawName:"v-show",value:1==t.roles&&1==t.routename,expression:"roles == 1 && routename == 1"}],staticStyle:{"font-size":"14px"}},[s("span",{staticClass:"el-dropdown-link",on:{click:t.openAction}},[t._v("\n                    Select Property"),s("i",{staticClass:"el-icon-arrow-down el-icon--right"})])]),s("div",{staticStyle:{"margin-right":"20px","font-size":"14px","margin-left":"20px"}},[t._v("\n                "+t._s(t.hotelName)+" \n                ")]),s("div",{staticClass:"btn-fullscreen",on:{click:t.handleFullScreen}},[s("el-tooltip",{attrs:{effect:"dark",content:(t.fullscreen,"Full screen"),placement:"bottom"}},[s("i",{staticClass:"el-icon-rank"})])],1),s("div",{staticStyle:{"font-size":"14px","margin-left":"10px"}},[s("el-dropdown",{attrs:{trigger:"click"},on:{command:t.selectLanguage}},[s("span",{staticClass:"el-dropdown-link"},[t._v("\n                        "+t._s(t.$t("header.selectproperty"))+"\n                    ")]),s("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[s("el-dropdown-item",{attrs:{command:"en"}},[t._v("English")]),s("el-dropdown-item",{attrs:{command:"zhCHS"}},[t._v("中文")])],1)],1)],1),t._m(0),s("el-dropdown",{staticClass:"user-name",attrs:{trigger:"click"},on:{command:t.handleCommand}},[s("span",{staticClass:"el-dropdown-link"},[t._v("\n                    "+t._s(t.username)+" "),s("i",{staticClass:"el-icon-caret-bottom"})]),s("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[s("el-dropdown-item",{attrs:{command:"loginout"}},[t._v(t._s(t.$t("header.logout")))])],1)],1)],1)]),s("el-dialog",{attrs:{title:"Switch Property",visible:t.hotelVisible,width:"78%",top:"5vh"},on:{"update:visible":function(e){t.hotelVisible=e}}},[s("el-dialog",{attrs:{width:"30%",title:"Whether to switch the following property？",visible:t.innerVisible,"append-to-body":""},on:{"update:visible":function(e){t.innerVisible=e}}},[s("div",[t._v(t._s(t.hotel))]),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(e){t.innerVisible=!1}}},[t._v("Cancel")]),s("el-button",{attrs:{type:"primary"},on:{click:t.confirmAction}},[t._v("Confirm")])],1)]),s("el-col",{staticStyle:{"padding-left":"0px","margin-bottom":"16px"},attrs:{span:24}},[s("el-input",{attrs:{placeholder:"Search By Name"},on:{input:t.changeInp},model:{value:t.inputVal,callback:function(e){t.inputVal=e},expression:"inputVal"}},[s("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"prefix"},slot:"prefix"})])],1),s("div",{staticClass:"nowRoom",attrs:{id:"nowRoom"}},t._l(t.hotelList,function(e,o){return s("span",{key:o,class:{hoverBg:t.hoverIndex==o},style:{background:t.getColor(o)},on:{mouseover:function(e){t.hoverIndex=o},mouseout:function(e){t.hoverIndex=-1},click:function(e){t.selectAction(o)}}},[s("p",{style:{color:t.getwordColor(o)}},[t._v(t._s(e.name))])])}),0)],1)],1)},a=[function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"user-avator"},[o("img",{attrs:{src:s("7159")}})])}],i=(s("28a5"),s("7f7f"),s("7ed4")),r={data:function(){return{hotel:"",hotelId:"",hoverIndex:-1,collapse:!1,fullscreen:!1,hotelVisible:!1,innerVisible:!1,name:"linxin",message:2,inputVal:"",hotelList:[],hotelData:this.$store.state.tableData,rolesList:this.$store.state.user.roles,roles:"",routename:1,hotelName:window.localStorage.getItem("address")||JSON.parse(window.localStorage.getItem("user")).pgshHotelEntityList[0].name}},computed:{username:function(){var t=JSON.parse(localStorage.getItem("user")).name;return t||this.name}},created:function(){var t=this;this.getHotelData(),this.getRole(),i["a"].$on("hotelData",function(e){t.hotelList=e}),i["a"].$on("routename",function(e){t.routename="Room Management"==e?0:1}),i["a"].$on("selectHotel",function(e){t.routename="Room Management"==e?0:1}),i["a"].$on("hotelname",function(e){t.hotelName=e})},methods:{changeInp:function(t){var e=this;t?this.getSearch(t):e.getHotelData()},selectLanguage:function(t){this.$i18n.locale=t,window.localStorage.setItem("lang",t),this.$emit("changeAppLocale",t),window.location.reload()},getSearch:function(t){var e=this;this.postRequest("/system/hotel//searchHotelByItems",{name:t}).then(function(t){t&&200==t.status?(console.log(t.data),e.hotelList=t.data.data):console.log("操作失败")})},getRole:function(){var t=this;this.rolesList.map(function(e){"ROLE_admin"==e.name&&(t.roles=1)})},getColor:function(t){if(this.hotelName==this.hotelList[t].name)return"#157df5"},getwordColor:function(t){if(this.hotelName==this.hotelList[t].name)return"#fff"},openAction:function(){this.hotelVisible=!0},getTime:function(){this.postRequest("/system/hotel/getThisOfficeWorkTime",{id:window.localStorage.getItem("eid")||this.eid}).then(function(t){t&&200==t.status&&(window.localStorage.setItem("startTime",t.data.obj.startTime),window.localStorage.setItem("endTime",t.data.obj.endTime),window.localStorage.setItem("addTime",t.data.obj.addTime))})},selectAction:function(t){this.innerVisible=!0,this.hotel=this.hotelList[t].name,this.hotelId=this.hotelList[t].id},confirmAction:function(){window.localStorage.setItem("address",this.hotel),window.localStorage.setItem("eid",this.hotelId),this.getTime(),window.location.reload()},getHotelData:function(){var t=this;this.postRequest("/system/hotel/selectHotelByUid").then(function(e){e&&200==e.status&&(console.log(e.data),t.hotelList=e.data.data)})},changeHotel:function(t){var e=t.split("+")[0],s=t.split("+")[1];window.localStorage.setItem("eid",e),window.localStorage.setItem("address",s),window.location.reload()},handleCommand:function(t){var e=this;"loginout"==t&&this.postRequest("/logout").then(function(t){t&&200==t.status&&(e.$store.commit("logout"),sessionStorage.removeItem("user"),localStorage.removeItem("user"),localStorage.removeItem("eid"),localStorage.removeItem("flag"),localStorage.removeItem("address"),e.$router.push("/login"),o&&clearTimeout(o),o=setTimeout(function(){o=null},1e3))})},collapseChage:function(){this.collapse=!this.collapse,i["a"].$emit("collapse",this.collapse)},handleFullScreen:function(){var t=document.documentElement;this.fullscreen?document.exitFullscreen?document.exitFullscreen():document.webkitCancelFullScreen?document.webkitCancelFullScreen():document.mozCancelFullScreen?document.mozCancelFullScreen():document.msExitFullscreen&&document.msExitFullscreen():t.requestFullscreen?t.requestFullscreen():t.webkitRequestFullScreen?t.webkitRequestFullScreen():t.mozRequestFullScreen?t.mozRequestFullScreen():t.msRequestFullscreen&&t.msRequestFullscreen(),this.fullscreen=!this.fullscreen}},mounted:function(){document.body.clientWidth<1500&&this.collapseChage()}},l=r,c=(s("da10"),s("2877")),u=Object(c["a"])(l,n,a,!1,null,null,null);e["default"]=u.exports},da10:function(t,e,s){"use strict";var o=s("3785"),n=s.n(o);n.a},dbc2:function(t,e,s){"use strict";var o=s("ea59"),n=s.n(o);n.a},ea59:function(t,e,s){}}]);