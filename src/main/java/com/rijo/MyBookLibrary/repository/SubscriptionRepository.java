package com.rijo.MyBookLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rijo.MyBookLibrary.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

}
