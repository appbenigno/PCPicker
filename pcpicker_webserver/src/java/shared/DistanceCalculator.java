/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::                                                                         :*/
/*::  This routine calculates the distance between two points (given the     :*/
/*::  latitude/longitude of those points). It is being used to calculate     :*/
/*::  the distance between two locations using GeoDataSource (TM) prodducts  :*/
/*::                                                                         :*/
/*::  Definitions:                                                           :*/
/*::    South latitudes are negative, east longitudes are positive           :*/
/*::                                                                         :*/
/*::  Passed to function:                                                    :*/
/*::    lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees)  :*/
/*::    lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees)  :*/
/*::    unit = the unit you desire for results                               :*/
/*::           where: 'M' is statute miles (default)                         :*/
/*::                  'K' is kilometers                                      :*/
/*::                  'N' is nautical miles                                  :*/
/*::  Worldwide cities and other features databases with latitude longitude  :*/
/*::  are available at http://www.geodatasource.com                          :*/
/*::                                                                         :*/
/*::  For enquiries, please contact sales@geodatasource.com                  :*/
/*::                                                                         :*/
/*::  Official Web site: http://www.geodatasource.com                        :*/
/*::                                                                         :*/
/*::           GeoDataSource.com (C) All Rights Reserved 2015                :*/
/*::                                                                         :*/
/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
package shared;

import Pcpicker_webserviceForDesktop.Branch;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import pcpicker.Coordinates;
import pcpicker.Order;

/**
 *
 * @author admin
 */
public class DistanceCalculator {
    
    public static double distance(Coordinates co1, Coordinates co2) {
        double lat1 = co1.getLat();
        double lon1 = co1.getLng();
        
        double lat2 = co2.getLat();
        double lon2 = co2.getLng(); 
        
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;      
        dist = dist * 1.609344;       

        return (dist);
    }
    
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
       
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;      
        dist = dist * 1.609344;       

        return (dist);
    }

  
    public static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

   
    public static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
    public static int getNearestBranch(String address, ArrayList<Branch> branchList)
    {
       
        Coordinates deliveryAddress = Coordinates.getCoordinates(address);
        double lowestDistance = DistanceCalculator.distance(deliveryAddress,branchList.get(0).getCoordinates());
        Branch nearestBranch = branchList.get(0);
        for(int i=1; i < branchList.size(); i++)
        {
            double distance = DistanceCalculator.distance(deliveryAddress,branchList.get(i).getCoordinates());
            if(distance<lowestDistance)
            {
                lowestDistance = distance;
                nearestBranch = branchList.get(i);
            }            
        }
        
        return nearestBranch.getBranch_id();
    }
      
    public static int getNextNearestBranch(Order order, ArrayList<Branch> branchList)            
    {
        Coordinates currentBranchCoord = getBranch(order.getNearestBranchRequest(), branchList).getCoordinates();
        Coordinates deliveryAddress = Coordinates.getCoordinates(order.getDeliveryAddress());
        double currentDistance = DistanceCalculator.distance(deliveryAddress, currentBranchCoord);
        
        
        double nextLowestDistance = 9999;
        Branch nextNearestBranch = null;
        Boolean nextNearestFound = false;
        for(int i=0; i < branchList.size(); i++)
        {
            double distance = DistanceCalculator.distance(deliveryAddress,branchList.get(i).getCoordinates());
            System.out.println("distance " + distance);
            System.out.println("nextLowestDistance "+nextLowestDistance);
            System.out.println("currentDistance " + currentDistance);
            System.out.println("..");
            if(distance<nextLowestDistance && distance > currentDistance)
            {
                nextLowestDistance = distance;
                nextNearestBranch = branchList.get(i);
                nextNearestFound = true;
                System.out.println("foundnext");
            }            
        }
        if(!nextNearestFound)
            return getNearestBranch(order.getDeliveryAddress(), branchList);
        
        return nextNearestBranch.getBranch_id();
        
    }
    
    private static Branch getBranch(int branchid, ArrayList<Branch> branches)
    {
        for(Branch branch : branches)
            if(branch.getBranch_id() == branchid)
                return branch;
        
        return null;      
        
    }
   
}
