package org.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Company {
  private int id;

  private String country;

  private boolean isHeadQuarter;

  private int capital;

  private String name;

  private String foundation;
}
