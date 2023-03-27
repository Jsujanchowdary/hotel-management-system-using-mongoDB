package com.vit.hms.dao;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.vit.hms.bean.RentalPropertyBean;
import com.vit.hms.util.DBUtil;

public class RentalPropertyDAO {

    static DBUtil con=new DBUtil();
    static MongoDatabase db = con.getDBConnection();
    static MongoCollection<Document> docs = db.getCollection("RENTAL_TBL");
    
    public static String generatePropertyID(String city) {
        String dig=Integer.toString((int)Math.floor(Math.random()*10000));
        String id=city.substring(0, 3).toUpperCase().concat(dig);
        return id;
        
    }

    public static int createRentalProperty(RentalPropertyBean bean){
        
            // MongoIterable<String> itr=db.listCollectionNames();
            // ListDatabasesIterable<Document> list=mongo.listDatabases();

            Document document=new Document();
            document.put("PROPERTYID", generatePropertyID(bean.getcity()));
            document.put("RENTALAMOUNT", bean.getRentalAmount());
            document.put("NOOFBEDROOMS", bean.getnoOfBedRooms());
            document.put("LOCATION", bean.getlocation());
            document.put("CITY", bean.getcity());
            docs.insertOne(document);
            
            // docs.insertMany(null);

            // for (String i : itr) {
            //     System.out.println(i);
            // }
            // System.out.println(dbs);
            return 1;
    }

    public static List<RentalPropertyBean> findPropertyByCriteria(
        float minRentalAmount,float maxRentalAmout,RentalPropertyBean bean){

            List<RentalPropertyBean> lst=new ArrayList<RentalPropertyBean>();

            List<Document> searchQuery = docs.find(and(
                gte("RENTALAMOUNT",minRentalAmount),
                lte("RENTALAMOUNT",maxRentalAmout),
                eq("NOOFBEDROOMS", bean.getnoOfBedRooms()),
                regex("LOCATION", bean.getlocation(),"i"),
                regex("CITY", bean.getcity(),"i")))
                .into(new ArrayList<>());
            
            
            for (Document p : searchQuery) {
                // System.out.println(p.toJson());
                RentalPropertyBean b= new RentalPropertyBean();
                b.setpropertyId(p.get("PROPERTYID").toString());
                b.setrentalAmount((int)Double.parseDouble(p.get("RENTALAMOUNT").toString()));
                b.setnoOfBedRooms((int)Double.parseDouble(p.get("NOOFBEDROOMS").toString()));
                b.setlocation(p.get("LOCATION").toString());
                b.setcity(p.get("CITY").toString());
                lst.add(b);
            };

            return lst;
        }
}
