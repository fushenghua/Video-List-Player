package com.mate.videolist.visibility.scroll;


import com.mate.videolist.visibility.items.ListItem;

/**
 * This interface is used by {@link com.mate.videolist.visibility.calculator.SingleListViewItemActiveCalculator}.
 * Using this class to get {@link ListItem}
 *
 * @author Wayne
 */
public interface ItemsProvider {

    ListItem getListItem(int position);

    int listItemSize();

}
