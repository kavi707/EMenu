package com.kavi.droid.emenu.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import com.kavi.droid.emenu.services.connections.ApiCalls;
import com.kavi.droid.emenu.services.sharedPreferences.SharedPreferenceManager;
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
    private ProgressDialog progress;

    private Context context;
    private Activity ownerActivity;
    private CartListItemAdapter cartListItemAdapter;

    private CommonUtils commonUtils = new CommonUtils();
    private ApiCalls apiCalls = new ApiCalls();

    public CartListDialog(Context context) {
        super(context);
        this.context = context;

        ownerActivity = (context instanceof Activity)? (Activity)context: null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_cart_list);

        setUpViews();
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
                    placeOrder();
                } else {
                    Toast.makeText(context, "Please select items to your order", Toast.LENGTH_LONG).show();
                }
                dismiss();
            }
        });
    }

    private void loadCartItemListView(List<CartItem> cartItemList) {
        cartListItemAdapter = new CartListItemAdapter(cartItemList, context);
        cartListView.setAdapter(cartListItemAdapter);
    }


    private void placeOrder() {

        // TODO - This is only demo purpose to update the server with table number
        /*if (commonUtils.isOnline(context)) {

            if (progress == null) {
                progress = LoadingProgressBarDialog.createProgressDialog(context);
            }
            progress.show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    String response = apiCalls.updateTableStatus(Constants.SYNC_METHOD,
                            SharedPreferenceManager.getCurrentUserToken(context),
                            CommonUtils.selectedTable.getTableUUID(), 1);

                    ownerActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progress.dismiss();
                        }
                    });
                }
            }).start();
        } else {
            Toast.makeText(context, "Please check device Internet connection.", Toast.LENGTH_SHORT).show();
        }*/
    }
}
