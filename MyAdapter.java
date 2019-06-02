package com.example.cargarempresas;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<List_data>list_data;
    public ImageView logo;
    public String url;

    public MyAdapter(List<List_data> list_data) {
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List_data listData=list_data.get(position);
        holder.txtname.setText(listData.getNombre());
        holder.txtmovie.setText(listData.getTelefono());
        //holder.logo.setImageResource(listData.getLogo());
        Log.d("Logo","Logo EMp >"+url+listData.getLogo());

        Picasso.get()
                .load(url+listData.getLogo())
                .placeholder(R.mipmap.ic_launcher)
                .resize(400, 400)
                .centerCrop()
                .rotate(0)
                .into(logo, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("CARGAR EMPRESA","EMPRESA >");
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("URL ->",""+url);
                        Log.e("error", "ERror ->"+e);

                    }
                });

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname,txtmovie;

        public ViewHolder(View itemView) {
            super(itemView);

            txtname=(TextView)itemView.findViewById(R.id.txt_name);
            txtmovie=(TextView)itemView.findViewById(R.id.txt_moviename);
            logo=(ImageView)itemView.findViewById(R.id.imageView);
            url=new String("http://192.168.1.5/reecorriendocundinamarca.com/img_lugares/");




        }
    }
}