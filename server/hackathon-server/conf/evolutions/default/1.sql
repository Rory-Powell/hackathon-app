# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table patient (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_patient primary key (id))
;

create sequence patient_seq;




# --- !Downs

drop table if exists patient cascade;

drop sequence if exists patient_seq;

