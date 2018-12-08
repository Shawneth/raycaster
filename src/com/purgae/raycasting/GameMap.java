/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.purgae.raycasting;

/**
 *
 * @author Duke Wooze
 */
public class GameMap {
    
    String name;
    int width;
    int height;
    int[][] mapArray;
    
    public GameMap(int width, int height, String name) {
        
        this.name = name;
        this.width = width;
        this.height = height;
        this.mapArray = new int[width][height];
 
        for (int j = 0; j < height; j++) {
            
            for (int i = 0; i < width; i++) {
                if (j == 0 || j == height - 1) {
                    
                    mapArray[i][j] = 1;
                   
                } else {
                    
                    mapArray[0][j] = 1;
                    mapArray[width-1][j] = 1;
                    
                }                
            } 
        }  
    }
    
    
    public void printMapToConsole() {
        
        for (int j = 0; j < height; j++){
            
            for (int i = 0; i < width; i++) {
               
                System.out.print(mapArray[i][j]); 
            }
            System.out.println();
        }  
    }
    
    public String getName(){
        
        return this.name;
    }
    
}
