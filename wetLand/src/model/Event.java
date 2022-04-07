package model;

public class Event {
    
    private TypeEvent type;
    private String eventOrganizer;
    private double price;
    private String description;
    private Date date;
    
    
    public Event(int type, String eventOrganizer, double price, String description,int day, int month,int year) {
        switch(type){
            case 1:
            this.type= TypeEvent.MAINTENANCE;
            break;
            case 2:
            this.type = TypeEvent.SCHOOLVISITS;
            break;
            case 3:
            this.type = TypeEvent.ACTIVITIES;
            break;
            case 4:
            this.type = TypeEvent.CELEBRATION;
            break;
        }
        this.eventOrganizer = eventOrganizer;
        this.price = price;
        this.description = description;
        this.date = new Date(day, month, year);
    }

   


    

    public int getDate() {
        return date.getYear();
    }


    /**
     * @return String return the eventOrganizer
     */
    public String getEventOrganizer() {
        return eventOrganizer;
    }

    /**
     * @param eventOrganizer the eventOrganizer to set
     */
    public void setEventOrganizer(String eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event [description=" + description + ", eventOrganizer=" + eventOrganizer + ", price=" + price
                + ", type=" + type + "]";
    }


    /**
     * @return TypeEvent return the type
     */
    public TypeEvent getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeEvent type) {
        this.type = type;
    }

}
