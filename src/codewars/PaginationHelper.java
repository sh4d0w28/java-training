package codewars;
import java.util.List;

public class PaginationHelper<I> {

    private int itemCount = 0;
    private int itemsPerPage = 1;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.itemCount = collection.size();
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.itemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int pages = this.itemCount / itemsPerPage;
        if (this.itemCount % itemsPerPage != 0) {
            return pages + 1;
        }
        return pages;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int pages = this.itemCount / itemsPerPage;
        if (pageIndex <= pages) {
            return this.itemCount;
        } else if (pageIndex <= pages + 1 && this.itemCount % itemsPerPage != 0) {
            return this.itemCount % itemsPerPage;
        } else {
            return -1;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex > this.itemCount) {
            return -1;
        }

        int page = itemIndex /  this.itemsPerPage;
        if (itemIndex - this.itemsPerPage * page > 0) {
            return page + 1;
        } else {
            return page;
        }
    }
}