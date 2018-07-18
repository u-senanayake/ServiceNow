package skysoft.udayanga.com.servicenow.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import skysoft.udayanga.com.servicenow.model.Farmer;

public class FarmerDataAdapter extends BaseAdapter {
    private ArrayList<Farmer> farmers;
    private LayoutInflater layoutInflater;
    private Context context;

    public FarmerDataAdapter(Context context, ArrayList<Farmer> farmers) {
        this.farmers = farmers;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return farmers.size();
    }

    @Override
    public Object getItem(int position) {
        return farmers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecyclerView.ViewHolder holder;

        return null;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
