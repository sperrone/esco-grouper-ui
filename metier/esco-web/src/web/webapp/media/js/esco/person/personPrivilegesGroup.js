/*
 * Copyright (C) 2009 GIP RECIA http://www.recia.fr
 * @Author (C) 2009 GIP RECIA <contact@recia.fr>
 * @Contributor (C) 2009 SOPRA http://www.sopragroup.com/
 * @Contributor (C) 2011 Pierre Legay <pierre.legay@recia.fr>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 * @author aChesneau
 */
var PersonPrivilegesGroupPrototype = $.extend( true, {}, EscoGrid ,{

	/**
    * {@inheritDoc}
    */
	doOnFire : function(){
		fluid.accessibletabs("escoTabs", "escoPanels");
		person.setMethodToCall("group");
		return true;
	},

	/**
	 * {@inheritDoc}
	 */
	doActionOnFindData:function(data){
		person.getIsPersonModified();
	},

	/**
    * {@inheritDoc}
    */
	getPostDataToFindDataRequest : function(){
		var json = $.extend({
			personId : $("input[id=idPerson]").val(),
			privilegeType : $("input[name=privilegesRadio]:checked").val()
		}, Core.getUrlParams());
		Core.resetNavParams();
		return json;
	},

	/**
     * {@inheritDoc}
     */
	getIfSelectable : function(){
		privilegeRadioValue = $("input[name=privilegesRadio]:checked").val();
		if (privilegeRadioValue == "PRIVILEGE_RADIO_EFFECTIVE" ||	privilegeRadioValue == "PRIVILEGE_RADIO_ALL"){
			this._options.IS_SELECTABLE_GRID = false;
		} else {
			this._options.IS_SELECTABLE_GRID = true;
		}
	},

   /**
    * {@inheritDoc}
    */
	doIsMultipleViewGrid:function(){
		privilegeRadioValue = $("input[name=privilegesRadio]:checked").val();
		if (privilegeRadioValue == "PRIVILEGE_RADIO_EFFECTIVE" ||	privilegeRadioValue == "PRIVILEGE_RADIO_ALL"){
		}else{
			this._createNavBar();
			$("#pagerGrid_privilegeGroup > *").not(".navtable").hide();
			$($("#pagerGrid_privilegeGroup .nav-button")[1]).hide();
		}
	},

   /**
    * {@inheritDoc}
    */
	doSelectRow : function(rowid,status){
		if (status==false){
			$('input[id=cb_jqg]').attr('checked', false);
			this.nbRowSelected--;
		} else {
			this.nbRowSelected++;
		}
		this._updateRowSelectedInfo();
	},

	/**
     * {@inheritDoc}
     */
	doSelectAll:function(rowid,status){
		if (status) {
			this.nbRowSelected = parseInt($("#list_privilegeGroup").attr("p").records, 10);
		} else {
			this.nbRowSelected = 0;
		}
		this._updateRowSelectedInfo();
	},

	/**
     * {@inheritDoc}
     */
	doOnPaging:function(){
		this._selectType="undefined";
		this._sendSelectedRows();
		this._resizeGrid();
	},

	/**
     * {@inheritDoc}
     */
	doOnExistingAddedItems:function(){
		privilegeRadioValue = $("input[name=privilegesRadio]:checked").val();

		if (privilegeRadioValue == "PRIVILEGE_RADIO_EFFECTIVE" || privilegeRadioValue == "PRIVILEGE_RADIO_ALL") {
			if (this.isExistingAddedItems){
				$("#subtitleWarningPrivilege").empty().append(this._lang.WARNING_MESSAGE);
			}else{
				$("#subtitleWarningPrivilege").empty();
			}
		}else{
			$("#subtitleWarningPrivilege").empty();
		}
	},

	/**
     * {@inheritDoc}
     */
	doOnLoadComplete:function(data){

		privilegeRadioValue = $("input[name=privilegesRadio]:checked").val();


		if ((privilegeRadioValue == "PRIVILEGE_RADIO_EFFECTIVE" || privilegeRadioValue == "PRIVILEGE_RADIO_ALL")) {
			$("table[class*=navtable]").css("display","none");
			$("input[class=cbox]").css("display","none");
		} else {
			try {
				$("table[class*=navtable]").css("display","block");
				$("input[class=cbox]").css("display","block");
			} catch (e) {
			}
		}

		if (privilegeRadioValue == "PRIVILEGE_RADIO_EFFECTIVE" || privilegeRadioValue == "PRIVILEGE_RADIO_ALL") {
			var imgChecked = "<img id=\"?\" src=\"/" + Core.applicationContext + "/media/imgs/checked_not_clickable.png\" checked=\"true\" style=\"width : 15px; height : 15px; cursor : pointer;\"/>";
			var imgUnChecked = "<img id=\"?\" src=\"/" + Core.applicationContext + "/media/imgs/unchecked_not_clickable.png\" checked=\"false\" style=\"width : 15px; height : 15px; cursor : pointer;\" />";
		}else{
			var imgChecked = "<img id=\"?\" src=\"/" + Core.applicationContext + "/media/imgs/checked.png\" checked=\"true\" style=\"width : 15px; height : 15px; cursor : pointer;\"/>";
			var imgUnChecked = "<img id=\"?\" src=\"/" + Core.applicationContext + "/media/imgs/unchecked.png\" checked=\"false\" style=\"width : 15px; height : 15px; cursor : pointer;\" />";
		}

		var ids = $(this._options.ID_GRID).getDataIDs();
		for ( var i = 0; i < ids.length; i++) {
			var cl = ids[i];

			for ( var j = 4; j < 10; j++) {
				var data = $(this._options.ID_GRID).getCell(i + 1, j);
				if (data === "1"){
					imgCheckedTmp = imgChecked.replace("?", cl + "_col" + j);
					$(this._options.ID_GRID).setCell(i + 1, j, imgCheckedTmp, "", {title : ""});
				} else {
					imgUnCheckedTmp = imgUnChecked.replace("?", cl + "_col" + j);
					$(this._options.ID_GRID).setCell(i + 1, j, imgUnCheckedTmp, "", {title : ""});
				}
			}

			if( !(privilegeRadioValue == "PRIVILEGE_RADIO_EFFECTIVE" || privilegeRadioValue == "PRIVILEGE_RADIO_ALL")) {
				$("#" + cl + "_col4").bind("click", ActionRightCheckBox.clickOptinDefaultAction(this._options,person.getIsPersonModified));
				$("#" + cl + "_col4").attr("action" , "optin");

				$("#" + cl + "_col5").bind("click", ActionRightCheckBox.clickOptoutDefaultAction(this._options,person.getIsPersonModified));
				$("#" + cl + "_col5").attr("action" , "optout");

				$("#" + cl + "_col6").bind("click", ActionRightCheckBox.clickViewDefaultAction(this._options,person.getIsPersonModified));
				$("#" + cl + "_col6").attr("action" , "view");

				$("#" + cl + "_col7").bind("click", ActionRightCheckBox.clickReadDefaultAction(this._options,person.getIsPersonModified));
				$("#" + cl + "_col7").attr("action" , "read");

				$("#" + cl + "_col8").bind("click", ActionRightCheckBox.clickUpdateDefaultAction(this._options,person.getIsPersonModified));
				$("#" + cl + "_col8").attr("action" , "update");

				$("#" + cl + "_col9").bind("click", ActionRightCheckBox.clickAdminDefaultAction(this._options,person.getIsPersonModified));
				$("#" + cl + "_col9").attr("action" , "admin");
			}
		}
	},

	/**
     * {@inheritDoc}
     */
	addActionOnClickLinkItemGroup:function(id){
		if (Profile.canAccessToGroupProperties()){
			Core.addAction(
					$(id),
					Core.CLICK,
					function(e){
						_displayBlockUIOption = {
								onAfterShowBlockUI : function(){
									Core.log("Preparate open of node + " + e.target.id);
									TreePlugin.openAndSelectNode(e.target.id);
						}
						};
						Core._showBlockUI(_displayBlockUIOption);
					});
		}else{
			$(id).removeClass("tableLink");
		}
	},

	/**
     * {@inheritDoc}
     */
	doAddNavButtons:function(){
		var _this = this;

		var addAction = ActionNavBar.actionAddPersonDefault(_this,"/" + Core.applicationContext + "/stylesheets/personProperties.jsf",2,true);
		this._addANavButton(
				this._lang.ADD_LABEL,
				this._lang.ADD_TITLE,
				"/" + Core.applicationContext + "/media/imgs/grid/10551.add_exc.gif",
				addAction,
				"add"
				);

		var delAction = ActionNavBar.actionDelDefault(_this,"/" + Core.applicationContext + "/ajax/personPrivilegesGroupController/deleteItems.jsf",person.getIsPersonModified);
		this._addANavButton(
				this._lang.DEL_LABEL,
				this._lang.DEL_TITLE,
				"/" + Core.applicationContext + "/media/imgs/grid/14763.delete.gif",
				delAction,
				"del"
				);
	}
});


var PersonPrivilegesGroup = new DUI.Class(PersonPrivilegesGroupPrototype , $.screen);