package shoppinglist.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import shoppinglist.commands.AddItemCmd;
import shoppinglist.commands.ClearListCmd;
import shoppinglist.commands.StrikeItemCmd;
import shoppinglist.commands.UndoCmd;
import shoppinglist.model.NumerableItem;
import shoppinglist.services.dto.ItemDto;

/**
 * Implements the exposed REST endpoints for the shopping list service.
 *
 * <p>
 * This is the starting point for implementing the service.
 *
 * @author Bradford Hovinen <hovinen@gmail.com>
 */
@ApplicationScoped
@Path("/shopping-list")
public final class ShoppingListService {

    private final CommandExecutorService executor;

    @Inject
    ShoppingListService(CommandExecutorService executor) {
        this.executor = executor;
    }

    /**
     * Returns the entire current shopping list.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemDto> getWholeList() {
        List<ItemDto> wholeList = new ArrayList<>(executor.getShoppingList().getAllItems().size());
        for(NumerableItem item : executor.getShoppingList().getAllItems())
        {
          wholeList.add(new ItemDto(item.getName(), item.getAmount(), item.getUnitKey(), item.isStricken()));
        }
        return wholeList;
    }

    /**
     * Adds an item to the shopping list.
     *
     * @param articleName
     *            the name of the article
     * @param amount
     *            the amount
     * @param unit
     *            a string representing the unit of the amount
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public void addItem(
            @QueryParam("name") String articleName,
            @QueryParam("amount") int amount,
            @QueryParam("unit") String unitKey) {
    	executor.execute(new AddItemCmd(articleName, amount, unitKey));
    }

    /**
     * Marks the item identified by the given article and unit as completed.
     */
    @PUT
    @Path("/strike")
    public void strikeItem(
            @QueryParam("article") String articleName,
            @QueryParam("unit") String unitKey) {
        executor.execute(new StrikeItemCmd(articleName, unitKey));
    }

    /**
     * Clears the entire list of all items.
     */
    @PUT
    @Path("/clear")
    public void clearList() {
        executor.execute(new ClearListCmd());
    }

    /**
     * Reverts the last action taken on the shopping list.
     */
    @PUT
    @Path("/undo")
    public void undoLastAction() {
        executor.execute(new UndoCmd());
    }
}
