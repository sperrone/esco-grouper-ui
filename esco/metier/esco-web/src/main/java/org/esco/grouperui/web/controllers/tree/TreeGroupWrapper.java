package org.esco.grouperui.web.controllers.tree;

import org.esco.grouperui.domaine.beans.Group;
import org.esco.grouperui.domaine.beans.GroupPrivilegeEnum;
import org.esco.grouperui.exceptions.technicals.ESCOWrapperException;
import org.esco.grouperui.tools.IWrapper;
import org.esco.grouperui.tools.property.PropertyManager;
import org.esco.grouperui.web.beans.tree.Attributes;
import org.esco.grouperui.web.beans.tree.TreeNode;
import org.esco.grouperui.web.beans.tree.ViewData;

/**
 * The TreeStemWrapper class. Requirement(s):[RECIA-ESCO-L1-012]
 * 
 * @author aChesneau
 */
public class TreeGroupWrapper implements IWrapper < Group, TreeNode > {

    /**
     * The generated serial uid.
     */
    private static final long   serialVersionUID = -8182531829760907004L;

    /** Type group. */
    private static final String GROUP            = "GROUP";

    /**
     * Default constructor.
     */
    public TreeGroupWrapper() {
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode wrap(final Group theObjectSource) throws ESCOWrapperException {

        TreeNode treeGroup = new TreeNode();
        Attributes attributes = new Attributes();

        attributes.setId(theObjectSource.getIdGroup());
        attributes.setName(theObjectSource.getName());
        attributes.setDisplayName(theObjectSource.getDisplayName());
        attributes.setType(TreeGroupWrapper.GROUP);
        attributes.setRight(theObjectSource.getUserRight().getName());
        if (theObjectSource.isCanOptin()) {
            attributes.setOptin(Boolean.TRUE.toString());
        } else {
            attributes.setOptin(Boolean.FALSE.toString());
        }
        if (theObjectSource.isCanOptout()) {
            attributes.setOptout(Boolean.TRUE.toString());
        } else {
            attributes.setOptout(Boolean.FALSE.toString());
        }

        treeGroup.setAttributes(attributes);
        treeGroup.setData(this.getViewDataFormatted(theObjectSource));
        treeGroup.setState("");

        return treeGroup;
    }

    /**
     * Return the ViewData formatted from theFolder.
     * 
     * @param theGroup
     *            the group.
     * @return the ViewData
     */
    private ViewData getViewDataFormatted(final Group theGroup) {

        ViewData viewData = new ViewData();
        viewData.setTitle(theGroup.getDisplayExtension());

        String opt = "";
        String right = "";
        boolean optin = theGroup.isCanOptin();
        boolean optout = theGroup.isCanOptout();

        if (optin) {
            if (optout) {
                opt = GroupPrivilegeEnum.OPTIN.getName() + "_" + GroupPrivilegeEnum.OPTOUT.getName();
            } else {
                opt = GroupPrivilegeEnum.OPTIN.getName();
            }
        } else {
            if (optout) {
                opt = GroupPrivilegeEnum.OPTOUT.getName();
            } else {
                opt = "none";
            }
        }

        // theGroup.getUserRight() is not null here.
        right = theGroup.getUserRight().getName();

        viewData.setIcon(PropertyManager.find("group_" + right + "_" + opt).deType(String.class));

        return viewData;
    }

}
