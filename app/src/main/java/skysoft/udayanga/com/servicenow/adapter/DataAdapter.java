package skysoft.udayanga.com.servicenow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import skysoft.udayanga.com.servicenow.R;
import skysoft.udayanga.com.servicenow.model.City;

/**
 * Created by Udayanga on 1/26/2018.
 */

public class DataAdapter extends BaseAdapter {
    private ArrayList<City> cities;
    private LayoutInflater layoutInflater;
    private Context context;

    public DataAdapter(Context context, ArrayList<City> cities) {
        this.cities = cities;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.city_spinner_row, null);
            holder = new ViewHolder();
            holder.txtCity = convertView.findViewById(R.id.city_spinner_txt);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtCity.setText(cities.get(position).getCity());

        return convertView;
    }

    static class ViewHolder {
        TextView txtCity;

    }

}
