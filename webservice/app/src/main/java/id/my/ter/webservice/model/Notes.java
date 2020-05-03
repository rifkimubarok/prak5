package id.my.ter.webservice.model;

import org.json.JSONObject;

public class Notes {
    private String Id;
    private String Title;
    private String Content;

    public Notes(JSONObject jsonObject){
        try{
            this.Id = jsonObject.getString("id");
            this.Title = jsonObject.getString("title");
            this.Content = jsonObject.getString("content");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Notes(String title, String content){
        this.Title = title;
        this.Content = content;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
