package id.my.ter.webservice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import id.my.ter.webservice.R;
import id.my.ter.webservice.model.Notes;

public class NoteAdapter extends ArrayAdapter<Notes> {
    private static class ViewHolder {
        TextView id;
        TextView title;
    }
    public NoteAdapter(@NonNull Context context, ArrayList<Notes> notes) {
        super(context, R.layout.item_note, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Notes notes = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_note,parent,false);
            viewHolder.id = (TextView) convertView.findViewById(R.id.value_note_id);
            viewHolder.title = (TextView) convertView.findViewById(R.id.value_note_title);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.id.setText(notes.getId());
        viewHolder.title.setText(notes.getTitle());
        return convertView;
    }
}
