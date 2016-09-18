package com.kavi.droid.emenu.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kavi.droid.emenu.Constants;
import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.CartListItemAdapter;
import com.kavi.droid.emenu.adapters.CategoryListItemAdapter;
import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.models.Category;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kavi707 on 8/16/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CartListDialog extends Dialog {

    private ListView cartListView;
    private RelativeLayout drinksRelativeLayout;
    private TextView totalAmtTextView;
    private Button placeOrderBtn;

    private Context context;
    private CartListItemAdapter cartListItemAdapter;
    OnCartListDialogResult mCartListDialogResult;

    private CommonUtils commonUtils = new CommonUtils();

    public CartListDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_cart_list);

        setUpViews();
    }

    // Callback Interface
    public interface OnCartListDialogResult {
        void updatedItemCart(boolean isItemCartUpdated, boolean isPlacedOrder);
    }

    public void setCartListDialogResult (OnCartListDialogResult dialogResult) {
        mCartListDialogResult = dialogResult;
    }

    private void setUpViews() {

        cartListView = (ListView) findViewById(R.id.cartItemListView);
        drinksRelativeLayout = (RelativeLayout) findViewById(R.id.drinksRelativeLayout);
        totalAmtTextView = (TextView) findViewById(R.id.totalAmtTextView);
        placeOrderBtn = (Button) findViewById(R.id.placeOrderBtn);

        // Load the cart items
        loadCartItemListView(CommonUtils.selectedCartItemList);

        totalAmtTextView.setText("Rs. " + String.valueOf((int)commonUtils.getItemTotalAmt()));

        cartListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final int itemPosition = position;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                alertDialogBuilder.setTitle("Remove");
                alertDialogBuilder.setMessage("Are you sure to remove '"+
                        CommonUtils.selectedCartItemList.get(position).getName() +"' from list?")
                        .setPositiveButton("YES", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                CommonUtils.selectedCartItemList.remove(CommonUtils.selectedCartItemList.get(itemPosition));
                                dialogInterface.cancel();

                                // Load the cart items
                                loadCartItemListView(CommonUtils.selectedCartItemList);

                                totalAmtTextView.setText("Rs. " + String.valueOf((int)commonUtils.getItemTotalAmt()));

                                // Notify cart update
                                mCartListDialogResult.updatedItemCart(true, false);
                            }
                        })
                        .setNegativeButton("NO", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!CommonUtils.selectedCartItemList.isEmpty()) {
                    Toast.makeText(context, "YOU HAVE SUCCESSFULLY PLACED THE ORDER", Toast.LENGTH_LONG).show();
                    changeCartItemStatus();
                    // Notify cart update
                    mCartListDialogResult.updatedItemCart(true, true);
                } else {
                    Toast.makeText(context, "PLEASE SELECT ITEMS FROM MENU TO PLACE AN ORDER", Toast.LENGTH_LONG).show();
                }
                dismiss();
            }
        });
    }

    private void loadCartItemListView(List<CartItem> cartItemList) {
        cartListItemAdapter = new CartListItemAdapter(cartItemList, context);
        cartListView.setAdapter(cartListItemAdapter);
    }

    /**
     * Change the cart items status according to the event
     */
    public void changeCartItemStatus() {

        CartItem selectedCartItem;
        for (int i = 0; i < CommonUtils.selectedCartItemList.size(); i++) {
            selectedCartItem = CommonUtils.selectedCartItemList.get(i);
            if (selectedCartItem.getState() == Constants.CART_ITEM_STATE_NEW) {
                selectedCartItem.setState(Constants.CART_ITEM_STATE_ORDERED);
                CommonUtils.selectedCartItemList.set(i, selectedCartItem);
            }
        }
    }
}
