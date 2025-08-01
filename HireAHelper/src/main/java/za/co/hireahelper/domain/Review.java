/* Review.java

   Author: D.Jordaan (230613152)

   Date: 18 May 2025
*/

package za.co.hireahelper.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    private String reviewId;
    private int rating;
    private String comment;
    private LocalDateTime timeStamp;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProvider serviceProvider;

    protected Review() {
    }

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.timeStamp = builder.timeStamp;
        this.client = builder.client;
        this.serviceProvider = builder.serviceProvider;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getReviewId() {
        return reviewId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public Client getClient() {
        return client;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", timeStamp=" + timeStamp +
                ", clientId=" + (client != null ? client.getUserId() : "null") +
                ", serviceProviderId=" + (serviceProvider != null ? serviceProvider.getUserId() : "null") +
                '}';
    }

    public static class Builder {
        private String reviewId;
        private int rating;
        private String comment;
        private LocalDateTime timeStamp;
        private Client client;
        private ServiceProvider serviceProvider;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setTimeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder setClient(Client client) {
            this.client = client;
            return this;
        }

        public Builder setServiceProvider(ServiceProvider serviceProvider) {
            this.serviceProvider = serviceProvider;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.rating = review.rating;
            this.comment = review.comment;
            this.timeStamp = review.timeStamp;
            this.client = review.client;
            this.serviceProvider = review.serviceProvider;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
