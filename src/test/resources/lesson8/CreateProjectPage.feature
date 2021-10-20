Feature: create project page

  Background:
    Given I am autorized

    Scenario:
      Given I hover nav menu
      And I click my project
      And I click create project button
      When I fill project name
      And I select Organization
      And I select BusinessUnit
      And I select Curator
      And I select Rp
      And I select Administrator
      And I select Manager
      And I select Contact
      And I click Save And Close Button
      Then I can see all Projects Page