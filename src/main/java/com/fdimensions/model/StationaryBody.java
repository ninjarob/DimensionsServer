package com.fdimensions.model;

import com.fdimensions.math.Vector2;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;

/**
 * Created with IntelliJ IDEA.
 * User: rkevan
 * Date: 11/4/13
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationaryBody implements DimSFSObject {
    private Vector2 location;
    private int bodyType;
    private int radius;
    private ISFSObject sbObject;

    public StationaryBody(Vector2 location, int bodyType, int radius) {
        this.location = location;
        this.bodyType = bodyType;
        this.radius = radius;
    }

    public Vector2 getLocation() {
        return location;
    }

    public void setLocation(Vector2 location) {
        this.location = location;
    }

    public int getBodyType() {
        return bodyType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public ISFSObject getDimSFSObject() {
        if (null == sbObject) {
            initStationaryBodySFSObject();
        }
        return sbObject;
    }

    private void initStationaryBodySFSObject(){
        sbObject = new SFSObject();
        sbObject.putFloat("x", location.x);
        sbObject.putFloat("y", location.y);
        sbObject.putInt("bt", bodyType);
        sbObject.putInt("rad", radius);
    }

}
