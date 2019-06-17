package com.rajeshchinni;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String bandName;
    private String artist;
    private songList songs;   // changes made here


    // constructor
    public Album(String name, String artist) {
        this.bandName = bandName;
        this.artist = artist;
        this.songs = new songList(); // changes done here also
    }

    // method
    public boolean addSong (String title, double duration){                     // changes made in this method
        return this.songs.add(new Song(title, duration));

    }


    //method
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){   // changes made in this method
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


    private class songList{                       // new inner class created

        private ArrayList<Song> paata;

        public songList() {       // constructor -- select none
            this.paata = new ArrayList<Song>();  // manually done
        }

        //method
        public boolean add(Song gaana){
            if (paata.contains(gaana)){
                return false;
            }
            this.paata.add(gaana);
            return true;
        }

        // method
        private Song findSong(String title){
            for ( Song checkedSong: this.paata){
                if (checkedSong.getTitle().equals(title)){
                    return checkedSong;
                }
            }
            return null;
        }

        //method
        public Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if ((index > 0) && (index<paata.size())){
                return paata.get(index);
            }
            return null;
        }

    }



}
