package com.swashconvergence.apps.user.app_adapter;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.swashconvergence.apps.user.R;
import com.swashconvergence.apps.user.app_model.Form2;

import java.util.List;

/**
 * Created by suchismita.p on 11/5/2016.
 */

public class Form2Adapter extends RecyclerView.Adapter<Form2Adapter.MyViewHolder> {
    private Context mContext;
    private List<Form2> form2List;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView headline, address1, address2, city, state, country, pin, phoneno;
        public ImageView dots;
        public MyViewHolder(View view) {
            super(view);
            headline = (TextView) view.findViewById(R.id.headline);
            address1 = (TextView) view.findViewById(R.id.address1);
            address2 = (TextView) view.findViewById(R.id.address2);
            city = (TextView) view.findViewById(R.id.city);
            state = (TextView) view.findViewById(R.id.state);
            country = (TextView) view.findViewById(R.id.country);
            pin = (TextView) view.findViewById(R.id.pin);
            phoneno = (TextView) view.findViewById(R.id.phno);
            dots= (ImageView)view.findViewById(R.id.dots);
        }
    }
    public Form2Adapter(Context mContext, List<Form2> form2List) {
        this.mContext = mContext;
        this.form2List = form2List;
    }
    @Override
    public Form2Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.address_detail, parent, false);

        return new Form2Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Form2Adapter.MyViewHolder holder, int position) {
        Form2 album = form2List.get(position);
        holder.headline.setText(album.getHeadline() );
        holder.address1.setText(album.getAddress1()+ ", ");
        holder.address2.setText(album.getAddress2()+ ", ");
        holder.city.setText(album.getCity() + ", ");
        holder.state.setText(album.getState() + ", ");
        holder.country.setText(album.getCountry() + ", ");
        holder.pin.setText(album.getPin());
        holder.phoneno.setText(album.getPhoneno());
        holder.dots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.dots);
            }
        });
    }

    /**
     /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.selection_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new Form2Adapter.MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.edit:
                    Toast.makeText(mContext, "Edit", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.delete:
                    Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return form2List.size();
    }
}

