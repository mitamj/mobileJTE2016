package id.ac.unsyiah.elektro.mobile.sqlitecrud.model;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.unsyiah.elektro.mobile.sqlitecrud.R;


/**
 * Adapter untuk menghubungkan Cursor dengan ListView. Satu hasil query akan tampil pada satu baris
 * List.
 */
public class BarangCursorAdapter extends CursorAdapter {
    public BarangCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.satu_barang, parent, false);

    }

    public void bindView(View view, Context context, Cursor cursor){
        String nama = cursor.getString(cursor.getColumnIndexOrThrow(AturBarangDB.NAMA_BARANG));
        TextView txtNama = (TextView) view.findViewById(R.id.txtNama);
        txtNama.setText(nama);

        String sku = cursor.getString(cursor.getColumnIndexOrThrow(AturBarangDB.KODE_SKU));
        TextView txtKode = (TextView) view.findViewById(R.id.txtKode);
        txtKode.setText(sku);

        String gambarStr = cursor.getString(cursor.getColumnIndexOrThrow(AturBarangDB.GAMBAR));
        ImageView txtGambar = (ImageView) view.findViewById(R.id.imageView);
        int posisi = Integer.parseInt(gambarStr);
        int [] gambar = {R.drawable.untitled_,R.drawable.p_batik,R.drawable.p_pink,R.drawable.w_color,R.drawable.w_zebra};
        txtGambar.setImageResource(gambar[posisi]);


    }
}
