package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    public static int testCounter = 0;
    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @Nested
    @DisplayName("tests for 0 posts")
    class TestCalculateAdvStatisticsZeroPosts {
        @Test
        void testCalculateAdvStatisticsZeroPostsZeroUsers() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            List<String> resultUsersNames = new ArrayList<>();
            when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            int usersCount = statisticsCalculator.getUsersCount();
            int postsCount = statisticsCalculator.getPostsCount();
            int commentsCount = statisticsCalculator.getCommentsCount();
            double avgPostsPerUser = statisticsCalculator.getAvgPostsPerUser();
            double avgCommentsPerUser = statisticsCalculator.getAvgCommentsPerUser();
            double avgCommentsPerPost = statisticsCalculator.getAvgCommentsPerPost();
            statisticsCalculator.showStatistics();

            //Then
            assertEquals(0, usersCount);
            assertEquals(0, postsCount);
            assertEquals(0, commentsCount);
            assertEquals(0.0, avgPostsPerUser);
            assertEquals(0.0, avgCommentsPerUser);
            assertEquals(0.0, avgCommentsPerPost);
        }

        @Test
        void testCalculateAdvStatisticsZeroPosts100Users() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            List<String> resultUsersNames = generateUsersNamesListOfNUsers(100);
            when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            int usersCount = statisticsCalculator.getUsersCount();
            int postsCount = statisticsCalculator.getPostsCount();
            int commentsCount = statisticsCalculator.getCommentsCount();
            double avgPostsPerUser = statisticsCalculator.getAvgPostsPerUser();
            double avgCommentsPerUser = statisticsCalculator.getAvgCommentsPerUser();
            double avgCommentsPerPost = statisticsCalculator.getAvgCommentsPerPost();
            statisticsCalculator.showStatistics();

            //Then
            assertEquals(100, usersCount);
            assertEquals(0, postsCount);
            assertEquals(0, commentsCount);
            assertEquals(0.0, avgPostsPerUser);
            assertEquals(0.0, avgCommentsPerUser);
            assertEquals(0.0, avgCommentsPerPost);
        }
    }

    @Nested
    @DisplayName("tests for 1000 posts")
    class TestCalculateAdvStatistics1000Posts {
        @Test
        void testCalculateAdvStatistics1000PostsZeroComments() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            List<String> resultUsersNames = generateUsersNamesListOfNUsers(100);
            when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            int usersCount = statisticsCalculator.getUsersCount();
            int postsCount = statisticsCalculator.getPostsCount();
            int commentsCount = statisticsCalculator.getCommentsCount();
            double avgPostsPerUser = statisticsCalculator.getAvgPostsPerUser();
            double avgCommentsPerUser = statisticsCalculator.getAvgCommentsPerUser();
            double avgCommentsPerPost = statisticsCalculator.getAvgCommentsPerPost();
            statisticsCalculator.showStatistics();

            //Then
            assertEquals(100, usersCount);
            assertEquals(1000, postsCount);
            assertEquals(0, commentsCount);
            assertEquals(10.0, avgPostsPerUser);
            assertEquals(0.0, avgCommentsPerUser);
            assertEquals(0.0, avgCommentsPerPost);
        }

        @Test
        void testCalculateAdvStatistics1000Posts500Comments() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            List<String> resultUsersNames = generateUsersNamesListOfNUsers(100);
            when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(500);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            int usersCount = statisticsCalculator.getUsersCount();
            int postsCount = statisticsCalculator.getPostsCount();
            int commentsCount = statisticsCalculator.getCommentsCount();
            double avgPostsPerUser = statisticsCalculator.getAvgPostsPerUser();
            double avgCommentsPerUser = statisticsCalculator.getAvgCommentsPerUser();
            double avgCommentsPerPost = statisticsCalculator.getAvgCommentsPerPost();
            statisticsCalculator.showStatistics();

            //Then
            assertEquals(100, usersCount);
            assertEquals(1000, postsCount);
            assertEquals(500, commentsCount);
            assertEquals(10.0, avgPostsPerUser);
            assertEquals(5.0, avgCommentsPerUser);
            assertEquals(0.5, avgCommentsPerPost);
        }

        @Test
        void testCalculateAdvStatistics1000Posts2500Comments() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            List<String> resultUsersNames = generateUsersNamesListOfNUsers(100);
            when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(2500);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            int usersCount = statisticsCalculator.getUsersCount();
            int postsCount = statisticsCalculator.getPostsCount();
            int commentsCount = statisticsCalculator.getCommentsCount();
            double avgPostsPerUser = statisticsCalculator.getAvgPostsPerUser();
            double avgCommentsPerUser = statisticsCalculator.getAvgCommentsPerUser();
            double avgCommentsPerPost = statisticsCalculator.getAvgCommentsPerPost();
            statisticsCalculator.showStatistics();

            //Then
            assertEquals(100, usersCount);
            assertEquals(1000, postsCount);
            assertEquals(2500, commentsCount);
            assertEquals(10.0, avgPostsPerUser);
            assertEquals(25.0, avgCommentsPerUser);
            assertEquals(2.5, avgCommentsPerPost);
        }
    }

    private List<String> generateUsersNamesListOfNUsers(int usersQuantity) {
        List<String> resultUsersNamesList = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            String userName = "user" + n;
            resultUsersNamesList.add(userName);
        }
        return resultUsersNamesList;
    }
}
