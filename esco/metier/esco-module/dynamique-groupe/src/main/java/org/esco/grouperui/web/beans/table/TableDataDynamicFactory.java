package org.esco.grouperui.web.beans.table;

import java.util.Iterator;
import java.util.List;

import org.esco.grouperui.domaine.beans.Sortable;
import org.esco.grouperui.web.beans.dynamicgrouptree.LdapRequestResult;

/**
 * The TableData factory class.
 * Requirement(s):[RECIA-ESCO-L1-001],[RECIA-ESCO-L1
 * -021],[RECIA-ESCO-L1-008],[RECIA-ESCO-L2-001], [RECIA-ESCO-L2-002],
 * [RECIA-ESCO-L2-003]
 * 
 * @author aChesneau
 */
public class TableDataDynamicFactory {

    /**
     * Populate the REST class for the find the result of a ldap request.
     * 
     * @param theResult
     *            The result of the ldap request.
     * @param theRowDataWrapper
     *            The wrapper.
     * @param theSortBy
     *            The sort column.
     * @param theSortType
     *            The sort type.
     * @return the TableData populated.
     */
    public static TableData populate(final LdapRequestResult theResult,
            final org.esco.grouperui.web.beans.ISortableWrapper theRowDataWrapper, final String theSortBy,
            final String theSortType) {

        TableData tableData = new TableData();

        List < Sortable > partOfResult = theResult.getRowsSorted(theSortBy, theSortType);

        Iterator < Sortable > partOfResultIt = partOfResult.iterator();
        while (partOfResultIt.hasNext()) {
            RowData rowData = theRowDataWrapper.wrap(partOfResultIt.next());
            tableData.addARow(new TableRow(rowData));
        }

        tableData.setNbResult(theResult.getListOfSortableSize());
        if (partOfResult.size() == 0) {
            tableData.setNbResultPage("1");
        } else {
            tableData.setNbResultPage(theResult.getNumberOfPages());
        }

        tableData.setCurrentPage(theResult.getCurrentPage());
        return tableData;
    }

}
