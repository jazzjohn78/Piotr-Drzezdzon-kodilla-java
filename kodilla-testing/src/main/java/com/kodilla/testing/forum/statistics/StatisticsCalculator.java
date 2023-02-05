package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();
        //average posts and comments per user avoiding division by zero
        if(this.usersCount == 0){
            this.avgPostsPerUser = 0.0;
            this.avgCommentsPerUser = 0.0;
        } else {
            this.avgPostsPerUser = (double) this.postsCount / (double) this.usersCount;
            this.avgCommentsPerUser = (double) this.commentsCount / (double) this.usersCount;
        }
        //average comments per post avoiding division by zero
        if(this.postsCount == 0){
            this.avgCommentsPerPost = 0.0;
        } else {
            this.avgCommentsPerPost = (double) this.commentsCount / (double) this.postsCount;
        }
    }

    public void showStatistics(){
        System.out.println("Current statistics:" +
                "\nnumber of users: " + this.usersCount +
                "\nnumber of posts: " + this.postsCount +
                "\nnumber of comments: " + this.commentsCount +
                "\naverage number of posts per user: " + this.avgPostsPerUser +
                "\naverage number of comments per user: " + this.avgCommentsPerUser +
                "\naverage number of comments per post: " + this.avgCommentsPerPost);
    }
}
