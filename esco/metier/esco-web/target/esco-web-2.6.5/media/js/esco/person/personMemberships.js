var PersonMembershipsPrototype=$.extend(true,{},EscoGrid,{doOnFire:function(){return true
},getPostDataToFindDataRequest:function(){jsonData=$.extend({groupUuid:$("input[id=groupUuid]").val(),membershipType:$("input[name=membershipsRadio]:checked").val()},Core.getUrlParams());
Core.resetNavParams();
return jsonData
},doActionOnFindData:function(A){person.getIsPersonModified()
},getIfSelectable:function(){memberRadioValue=$("input[name=membershipsRadio]:checked").val();
if(memberRadioValue=="MEMBERSHIP_RADIO_EFFECTIVE"||memberRadioValue=="MEMBERSHIP_RADIO_ALL"){this._options.IS_SELECTABLE_GRID=false
}else{this._options.IS_SELECTABLE_GRID=true
}},doIsMultipleViewGrid:function(){memberRadioValue=$("input[name=membershipsRadio]:checked").val();
if(memberRadioValue=="MEMBERSHIP_RADIO_EFFECTIVE"||memberRadioValue=="MEMBERSHIP_RADIO_ALL"){}else{this._createNavBar();
$("#message").append("");
$("#pagerGridMembership > *").not(".navtable").hide();
$($("#pagerGridMembership .nav-button")[1]).hide()
}},doSelectRow:function(B,A){if(A==false){$("input[id=cb_jqg]").attr("checked",false);
this.nbRowSelected--
}else{this.nbRowSelected++
}this._updateRowSelectedInfo()
},doSelectAll:function(B,A){if(A){this.nbRowSelected=parseInt($("#listMembership").attr("p").records,10)
}else{this.nbRowSelected=0
}this._updateRowSelectedInfo()
},doOnPaging:function(){this._selectType="undefined";
this._sendSelectedRows();
this._resizeGrid()
},doOnExistingAddedItems:function(){memberRadioValue=$("input[name=membershipsRadio]:checked").val();
if(memberRadioValue=="MEMBERSHIP_RADIO_EFFECTIVE"||memberRadioValue=="MEMBERSHIP_RADIO_ALL"){if(this.isExistingAddedItems){$("#subtitleWarningMembership").empty().append(this._lang.WARNING_MESSAGE)
}else{$("#subtitleWarningMembership").empty()
}}else{$("#subtitleWarningMembership").empty()
}},doOnLoadComplete:function(){memberRadioValue=$("input[name=membershipsRadio]:checked").val();
if(memberRadioValue=="MEMBERSHIP_RADIO_EFFECTIVE"||memberRadioValue=="MEMBERSHIP_RADIO_ALL"){$("table[class*=navtable]").css("display","none");
$("input[class=cbox]").css("display","none")
}else{try{$("table[class*=navtable]").css("display","block");
$("input[class=cbox]").css("display","block")
}catch(A){}}},addActionOnClickLinkItemGroup:function(A){if(Profile.canAccessToGroupProperties()){Core.addAction($(A),Core.CLICK,function(B){Core.log("Preparate open of node + "+B.target.id);
_displayBlockUIOption={onAfterShowBlockUI:function(){Core.log("Preparate open of node + "+$("#"+B.target.id).attr("id"));
TreePlugin.openAndSelectNode(B.target.id)
}};
Core._showBlockUI(_displayBlockUIOption)
},true)
}else{$(A).removeClass("tableLink")
}},doAddNavButtons:function(){var A=this;
var C=ActionNavBar.actionAddPersonDefault(A,"/"+Core.applicationContext+"/stylesheets/personProperties.jsf",1,true);
this._addANavButton(this._lang.ADD_LABEL,this._lang.ADD_TITLE,"/"+Core.applicationContext+"/media/imgs/grid/10551.add_exc.gif",C,"add");
var B=ActionNavBar.actionDelDefault(A,"/"+Core.applicationContext+"/ajax/personMembershipsController/deleteItems.jsf",person.getIsPersonModified);
this._addANavButton(this._lang.DEL_LABEL,this._lang.DEL_TITLE,"/"+Core.applicationContext+"/media/imgs/grid/14763.delete.gif",B,"del")
}});
var PersonMemberships=new DUI.Class(PersonMembershipsPrototype,$.screen);