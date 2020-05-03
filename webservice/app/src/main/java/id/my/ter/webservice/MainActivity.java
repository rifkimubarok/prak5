package id.my.ter.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;
import id.my.ter.webservice.adapter.NoteAdapter;
import id.my.ter.webservice.client.NoteRestClient;
import id.my.ter.webservice.model.Notes;

public class MainActivity extends AppCompatActivity {
    private ListView noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteList = (ListView) findViewById(R.id.list_notes);
        getNotes();
    }



    private void getNotes(){
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept","application/json"));
        NoteRestClient.get(this,"api/notes",headers.toArray(new Header[headers.size()]),null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                Log.d("HASILNYA", response.toString());
                ArrayList<Notes> noteArray = new ArrayList<>();
                NoteAdapter noteAdapter = new NoteAdapter(MainActivity.this, noteArray);
                for (int i = 0; i< response.length(); i++){
                    try {
                        noteAdapter.add(new Notes(response.getJSONObject(i)));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                noteList.setAdapter(noteAdapter);
            }
        });
    }
}
