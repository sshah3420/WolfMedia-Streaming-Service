import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choice = displayMenuAndGetChoice(scanner);
            switch (choice) {
                case 1:
                    System.out.println("Insert/Update/Delete Artist selected");
                    System.out.println("   ");
                    System.out.println("Please select an operation:\n1. Insert artist info\n2. Update artist info\n3. Delete artist info");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the member ID:");
            			    int memberId = scanner.nextInt();
            			    scanner.nextLine();
            			    System.out.println("Please enter the first name:");
            			    String firstName = scanner.nextLine();
            			    System.out.println("Please enter the last name:");
            			    String lastName = scanner.nextLine();
            			    System.out.println("Please enter the country:");
            			    String country = scanner.next();
            			    System.out.println("Please enter the email:");
            			    String email = scanner.next();
            			    System.out.println("Please enter the phone number:");
            			    String phone = scanner.next();
            			    System.out.println("Please enter the label ID:");
            			    int labelId = scanner.nextInt();
            			    System.out.println("Please enter the status (active/retired):");
            			    String status = scanner.next();
            			    System.out.println("Please enter the type(Band/musician/composer):");
            			    String type = scanner.next();
            				ArtistInfoApi.enterArtistInfo(memberId, firstName, lastName, country, email, phone, labelId, status, type);
            				break;
            			case 2:
            				System.out.println("Please enter the Member ID: ");
            			    int member_Id = scanner.nextInt();
            			    System.out.println("Please enter the column name you want to edit: ");
            			    String column = scanner.next();
            			    System.out.println("Please enter the Value for the column: ");
            			    Object value = scanner.next();
            			    ArtistInfoApi.updateArtistInfo(member_Id, column, value );
            				break;
            			case 3:
            				System.out.println("Please enter the Member ID: ");
            			    int member_Id2 = scanner.nextInt();
            			    ArtistInfoApi.deleteArtistInfo(member_Id2);
            				break;
            			default:
            				System.out.println("Invalid choice.");
            		}
                    break;
                case 2:
                    System.out.println("Insert/Update/Delete Song selected");
                    System.out.println("   ");
                    System.out.println("Please select an operation:\n1. Insert Song info\n2. Update Song info\n3. Delete Song info");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the song_ID: ");
            			    int songId = scanner.nextInt();
            			    scanner.nextLine();
            			    System.out.println("Please enter the Title: ");
            			    String title = scanner.nextLine();
            			    System.out.println("Please enter the Duration: ");
            			    int duration = scanner.nextInt();
            			    System.out.println("Please enter the Release Date: ");
            			    String release_date = scanner.next();
            			    System.out.println("Please enter the Language: ");
            			    String language = scanner.next();
            			    System.out.println("Please enter the Country: ");
            			    String country = scanner.next();
            			    System.out.println("Please enter the Royalty Rate: ");
            			    double royalty_rate= scanner.nextDouble();
            			    System.out.println("Please enter the Label_ID: ");
            			    int label_id = scanner.nextInt();
            			    System.out.println("Please enter the Album_ID:");
            			    int album_id = scanner.nextInt();
            			    System.out.println("Please enter the Track Number:");
            			    int track_num = scanner.nextInt();
            			    System.out.println("Please enter the Play Count:");
            			    int play_count= scanner.nextInt();
            				SongInfoApi.enterSongInfo(songId, title, duration, release_date, language, country, royalty_rate, label_id, album_id, track_num, play_count);
            				break;
            			case 2:
            				System.out.println("Please enter the Song ID: ");
            			    int song_Id = scanner.nextInt();
            			    System.out.println("Please enter the column name you want to edit: ");
            			    String column = scanner.next();
            			    System.out.println("Please enter the Value for the column: ");
            			    Object value = scanner.next();
            				SongInfoApi.updateSongInfo(song_Id, column, value );
            				break;
            			case 3:
            				System.out.println("Please enter the Song ID: ");
            			    int Song_Id2 = scanner.nextInt();
            				SongInfoApi.deleteSongInfo(Song_Id2);
            				break;
            			default:
            				System.out.println("Invalid choice.");
            		}
                    break;
                case 3:
                	System.out.println("Insert/Update/Delete Host selected");
                    System.out.println("   ");
                    System.out.println("Please select an operation:\n1. Insert Host info\n2. Update Host info\n3. Delete Host info");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the member ID:");
            			    int memberId = scanner.nextInt();
            			    scanner.nextLine();
            			    System.out.println("Please enter the first name:");
            			    String firstName = scanner.nextLine();
            			    System.out.println("Please enter the last name:");
            			    String lastName = scanner.nextLine();
            			    System.out.println("Please enter the country:");
            			    String country = scanner.next();
            			    System.out.println("Please enter the email:");
            			    String email = scanner.next();
            			    System.out.println("Please enter the phone number:");
            			    String phone = scanner.next();
            			    System.out.println("Please enter the City:");
            			    String city = scanner.next();
            				PodcastHostInfoApi.enterPodcastHostInfo(memberId, firstName, lastName, country, email, phone, city);
            				break;
            			case 2:
            				System.out.println("Please enter the Member ID: ");
            			    int member_Id = scanner.nextInt();
            			    System.out.println("Please enter the column name you want to edit: ");
            			    String column = scanner.next();
            			    System.out.println("Please enter the Value for the column: ");
            			    Object value = scanner.next();
            			    PodcastHostInfoApi.updatePodcastHostInfo(member_Id, column, value );
            				break;
            			case 3:
            				System.out.println("Please enter the Member ID: ");
            			    int member_Id2 = scanner.nextInt();
            			    PodcastHostInfoApi.deletePodcastHostInfo(member_Id2);
            				break;
            			default:
            				System.out.println("Invalid choice.");
            		}                    break;
                case 4:
                	System.out.println("Insert/Update/Delete Episode selected");
                    System.out.println("   ");
                    System.out.println("Please select an operation:\n1. Insert Episode info\n2. Update Episode info\n3. Delete Episode info");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the Podcast_ID: ");
            			    int PodcastId = scanner.nextInt();
            			    System.out.println("Please enter the Episode_ID: ");
            			    int EpisodeId = scanner.nextInt();
            			    System.out.println("Please enter the Duration: ");
            			    int duration = scanner.nextInt();
            			    System.out.println("Please enter the Release Date: ");
            			    String release_date = scanner.next();
            			    System.out.println("Please enter the Ad Count: ");
            			    int AdCount = scanner.nextInt();
            			    scanner.nextLine();
            			    System.out.println("Please enter the Title: ");
            			    String Title = scanner.nextLine();
            			    System.out.println("Please enter the Bonus Rate: ");
            			    double BonusRate= scanner.nextDouble();
            			    System.out.println("Please enter the Listening Count: ");
            			    int ListeningCount = scanner.nextInt();
            				PodcastEpisodeInfoApi.enterPodcastEpisodeInfo(PodcastId, EpisodeId, AdCount, Title, duration, release_date, BonusRate, ListeningCount);
            				break;
            			case 2:
            				System.out.println("Please enter the Episode ID: ");
            			    int Episode_Id = scanner.nextInt();
            			    System.out.println("Please enter the column name you want to edit: ");
            			    String column = scanner.next();
            			    System.out.println("Please enter the Value for the column: ");
            			    Object value = scanner.next();
            			    PodcastEpisodeInfoApi.updatePodcastEpisodeInfo(column, value, Episode_Id);
            				break;
            			case 3:
            				System.out.println("Please enter the Episode ID: ");
            			    int Episode_Id2 = scanner.nextInt();
            			    System.out.println("Please enter the Podcast ID: ");
            			    int Podcast_ID = scanner.nextInt();
            			    PodcastEpisodeInfoApi.deletePodcastEpisodeInfo(Episode_Id2, Podcast_ID);
            				break;
            			default:
            				System.out.println("Invalid choice.");
            		}
            	    break;
                case 5:
                	System.out.println("Assign Operation selected");
                    System.out.println("   ");              
                    System.out.println("Please select an Assign operation:\n1. Assign Host to Podcast info\n2. Assign Album to Artist info\n3. Assign Song to Artist info\n4. Assign Artist to Record Label info\n5. Assign Episode to Podcast info\n6. Assign Song to Album");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the Member ID/ Host ID:");
            			    int memberId = scanner.nextInt();
            			    System.out.println("Please enter the Podcast ID:");
            			    int podcast_id = scanner.nextInt();
            			    AssignApi.assignPodcastHostToPodcast(memberId, podcast_id);
            				break;
            			case 2:
            				System.out.println("Please enter the Album ID:");
            			    int album_id = scanner.nextInt();
            			    System.out.println("Please enter the Podcast ID:");
            			    int artist_id = scanner.nextInt();
            			    AssignApi.assignArtistToAlbum(album_id, artist_id);
            				break;
            			case 3:
            				System.out.println("Please enter the Member ID/ Artist ID:");
            			    int artistId = scanner.nextInt();
            			    System.out.println("Please enter the Song ID:");
            			    int songId = scanner.nextInt();
            			    System.out.println("Please enter artist's contribution ( 1: Lead, 0: Guest): ");
            			    int is_leadId = scanner.nextInt();
            			    AssignApi.assignSongToArtist(artistId, songId, is_leadId);
            				break;
            			case 4:
            				System.out.println("Please enter the Label ID:");
            			    int label_id = scanner.nextInt();
            			    System.out.println("Please enter the Artist/Member ID:");
            			    int member_id = scanner.nextInt();
            			    AssignApi.assignArtistToRecordLabel(label_id, member_id);
            				break;
            			case 5:
            				System.out.println("Please enter the Podcast ID:");
            			    int podcast_Id = scanner.nextInt();
            			    System.out.println("Please enter the Episode ID:");
            			    int episode_id = scanner.nextInt();
            			    AssignApi.assignPodcastEpisodesToPodcast(podcast_Id, episode_id);
            				break;
            			case 6:
            				System.out.println("Please enter the Song ID:");
            			    int Song_Id = scanner.nextInt();
            			    System.out.println("Please enter the Album ID:");
            			    int Album_id = scanner.nextInt();
            			    AssignApi.assignSongToAlbum(Song_Id, Album_id);
            				break;
            			default:
            				System.out.println("Invalid choice.");
            		}                    break;
                case 6:
                	System.out.println("Enter/Update Artist Monthly Listeners selected");
                    System.out.println("   "); 
                    System.out.println("Please select an operation:\n1. Enter Artist Monthly Listeners info\n2. Update Artist Monthly Listeners");
    				choice = scanner.nextInt();
    		
    				switch (choice) {
    					case 1:
    						System.out.println("Please enter the Member ID/ Artist ID:");
    						int artistId = scanner.nextInt();
    						System.out.println("Please enter its Song Count");
    						int song_id = scanner.nextInt();
    						ArtistMonthlyListenersApi.enterArtistMonthlyListeners(artistId, song_id);
    						break;
    					case 2:
    						System.out.println("Please enter the Member ID/ Artist ID:");
    						 int artist_Id = scanner.nextInt();
    						System.out.println("Please enter its Song Count:");
    						int songid = scanner.nextInt();
    						ArtistMonthlyListenersApi.updateArtistMonthlyListeners(artist_Id, songid);
    						break;
    					default:
    						System.out.println("Invalid choice.");
    				}
                    break;
                    
                case 7:
                    System.out.println("Get Episodes By Podcast Selected");
    				System.out.println("Please enter the Podcast ID:");
    				int podcastId = scanner.nextInt();
    				GetEpisodesByPodcast.getEpisodesByPodcast(podcastId);
                    break;
                    
                case 8:
                    System.out.println("Get Songs By Artist Selected");
    				System.out.println("Please enter the Artist ID:");
                    int artistId = scanner.nextInt();
                    GetSongByArtistApi.getSongsbyArtist(artistId);
                    break;
    				
                case 9:
                    System.out.println("Get Songs By Album Selected");
                    System.out.println("Please enter the Album ID:");
    				int albumId = scanner.nextInt();
    				GetSongsByAlbumApi.getSongsbyAlbum(albumId);
                    break;
                    
                case 10:
                    System.out.println("Get Songs By Album Selected");
    				System.out.println("Please enter the Podcast ID:");
    				int podcast_Id = scanner.nextInt();
    				System.out.println("Please enter the Rating:");
    				Double Rating = scanner.nextDouble();
    				RatingApi.enterUpdatePodcastRating(podcast_Id, Rating);
                    break;
                    
                case 11:
                    System.out.println("Get Revenue By Month/ Year Selected");
                    System.out.println("   "); 
                    System.out.println("Please select an operation:\n1. Get revenue by Month\n2. Get revenue by year");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the Month");
            			    int month = scanner.nextInt();
            			    GetRevenueApi.getRevenuePerMonth(month);
            				break;
            			case 2:
            				System.out.println("Please enter the year");
            				int year = scanner.nextInt();
            				GetRevenueApi.getRevenuePerYear(year);
            				break;
            			default:
            				System.out.println("Invalid choice.");
            		}
            		
                case 12:
                    System.out.println("User Make Subscription Payment Selected");
                    System.out.println("   "); 
                    System.out.println("Please enter the User ID:");
                    int userId = scanner.nextInt();
                    MakeUserSubscriberPaymentsApi.makeUserSubscriberPayments(userId);
                    
                case 13:
                    System.out.println("Update Episode Listening Count selected");
                    System.out.println("   "); 
            		System.out.print("Enter Episode Id:");
            		int episode_id = Integer.parseInt(scanner.nextLine());
            		System.out.println("Enter New Total Listening Count:");
            		int count = Integer.parseInt(scanner.nextLine());
            		EpisodeCountApi.updateListeningCount(episode_id, count);
                    break;
                    
                case 14:
                    System.out.println("Update Song Play count / Monthly selected");
                    System.out.println("   "); 
            		System.out.print("Enter Song Id:");
            		int song_id = Integer.parseInt(scanner.nextLine());
            		System.out.println("Enter New Total Subscriber Count:");
            		int Count = Integer.parseInt(scanner.nextLine());
            		PlayCount.updatePlayCount(song_id, Count);
            		PlayCount.updateSongMonthCount(song_id, Count);
                    break;
                    
                case 15:
                    System.out.println("Payment to Podcast Host Selected");
                    System.out.println("   "); 
                    System.out.print("Enter Host Id to make payment:");
        			int song_Id = Integer.parseInt(scanner.nextLine());
        	        System.out.print("Enter a month (1-12): ");
        	        int month = scanner.nextInt();
        	        // Prompt the user to input a year
        	        System.out.print("Enter a year: ");
        	        int year = scanner.nextInt();
        	        
        	        System.out.println("You entered: " + month + "/" + year);
        	        PodcastHostPayment.makeHostPayment(song_Id, month, year);
        	        
                    break;
                    
                case 16:
                    System.out.println("Update Podcast Subscriber Count Selected");
                    System.out.println("   "); 
            		System.out.print("Enter Podcast Id:");
            		int podcast_id = Integer.parseInt(scanner.nextLine());
            		System.out.println("Enter New Total Subscriber Count:");
            		int count_no = Integer.parseInt(scanner.nextLine());
            		SubscriberCountApi.updateSubscriberCount(podcast_id, count_no);
                    break;
                    
                case 17:
                    System.out.println("Payment for Song selected");
                    System.out.println("   "); 
                    System.out.println("Please select an operation:\n1. Make Payment for a particular Song\n2. Make Payment for all songs given month");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the song_ID: ");
            			    int song_ID = scanner.nextInt();
            			    System.out.println("Please enter the month(01-12) :");
            			    int Month = scanner.nextInt();
            			    System.out.println("Please enter the year() :");
            			    int Year = scanner.nextInt();
            			    SongPaymentAPI.makePaymentGivenSong(song_ID, Month, Year);
            				break;
            			case 2:
            			    System.out.println("Please enter the month(01-12) :");
            			    int month1 = scanner.nextInt();
            			    System.out.println("Please enter the year() :");
            			    int year1 = scanner.nextInt();
            			    SongPaymentAPI.makeAllSongPayments(month1, year1);
            				break;
            			default:
            				System.out.println("Invalid choice.");
            		}
            		
                    break;
                    
                case 18:
                    System.out.println("Get Monthly Count Per Song/Artist/Album");
                    System.out.println("   "); 
                    System.out.println("Please select an operation:\n1. Get Monthly Count per Song \n2. Get Monthly Count Per Artist \n3. Get Monthly Count Per Album");
            		choice = scanner.nextInt();

            		switch (choice) {
            			case 1:
            				System.out.println("Please enter the Song ID: ");
            			    int Song_id = scanner.nextInt();
            			    GetMonthlyPlayCount.getMonthlyPlayCountPerSong(Song_id);
            				break;
            			case 2:
            				System.out.println("Please enter the Artist/ Member ID: ");
            			    int artist_id = scanner.nextInt();
            			    GetMonthlyPlayCount.getMonthlyPlayCountPerArtist(artist_id);
            				break;
            			case 3:
            				System.out.println("Please enter the Album ID: ");
            			    int album_id = scanner.nextInt();
            			    GetMonthlyPlayCount.getMonthlyPlayCountPerAlbum(album_id);
            				break;
            				
            			default:
            				System.out.println("Invalid choice.");
            		}
                    break;
                    
                case 19:
                    System.out.println("Get Payment to Host/ Artist/ Label Selected");
                    System.out.println("   "); 
                    System.out.println("Please enter period:");
        			System.out.println("Enter start month:");
        			int startMonth = Integer.parseInt(scanner.nextLine());
        			System.out.println("Enter start year:");
        			int startYear = Integer.parseInt(scanner.nextLine());
        			System.out.println("Enter end month:");
        			int endMonth = Integer.parseInt(scanner.nextLine());
        			System.out.println("Enter end year:");
        			int endYear = Integer.parseInt(scanner.nextLine());
        			
        			System.out.println("Please enter 1.Host 2.Artist 3.Label:");
        			choice = scanner.nextInt();
        			switch(choice) {
        				case 1:
        					System.out.println("Enter Host Id to fetch payment record:");
        					int host_id = scanner.nextInt();
        					PaymentToHostArtistLabelApi.paidToHost(host_id,startMonth,startYear,endMonth,endYear);
        					break;
        					
        					
        				case 2:
        					System.out.println("Enter Artist Id to fetch payment record:");
        					int artist_id = scanner.nextInt();
        					PaymentToHostArtistLabelApi.paidToArtist(artist_id,startMonth,startYear,endMonth,endYear);
        					break;
        					
        					
        				case 3:
        					System.out.println("Enter Label Id to fetch payment record:");
        					int label_id = scanner.nextInt();
        					PaymentToHostArtistLabelApi.paidToLabel(label_id,startMonth,startYear,endMonth,endYear);
        					break;
        				
        				default:
        					System.out.println("Invalid choice.");

        					
        			}
                    break;
                    
                case 20:
                    System.out.println("Exiting program...");
                    break;
                    
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        } while (choice != 20);
    }

    public static int displayMenuAndGetChoice(Scanner scanner) {
        System.out.println("Please select a task:");
        System.out.println("1. Insert/Update/Delete Artist");
        System.out.println("2. Insert/Update/Delete Song");
        System.out.println("3. Insert/Update/Delete Host");
        System.out.println("4. Insert/Update/Delete Episode");
        System.out.println("5. Assignment Operation");
        System.out.println("6. Enter/Update Artist Monthly Listeners");
        System.out.println("7. Get Episodes By Podcast");
        System.out.println("8. Get Songs By Artist");
        System.out.println("9. Get Songs By Album");
        System.out.println("10. Enter/Update Ratings for Podcast");
        System.out.println("11. Get Revenue");
        System.out.println("12. User Subscribes to Service");
        System.out.println("13. Update Episode Listening Count");
        System.out.println("14. Update Song Play count / Monthly");
        System.out.println("15. Payment to Podcast Host");
        System.out.println("16. Update Podcast Subscriber Count");
        System.out.println("17. Payment for song");
        System.out.println("18. Get Monthly Count Per Song/Artist/Album");
        System.out.println("19. Get Payment to Host/ Artist/ Label");
        System.out.println("20. Exit");
        System.out.println("   ");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}
