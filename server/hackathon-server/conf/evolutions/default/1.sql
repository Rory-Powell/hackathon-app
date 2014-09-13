# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bed (
  bed_id                    varchar(255) not null,
  ward                      integer,
  constraint pk_bed primary key (bed_id))
;

create table doctor (
  id                        varchar(255) not null,
  constraint pk_doctor primary key (id))
;

create table patient (
  id                        varchar(255) not null,
  name                      varchar(255),
  dob                       timestamp,
  address                   varchar(255),
  gp                        varchar(255),
  doctor_id                 varchar(255),
  previous_doc_id           varchar(255),
  ailment                   varchar(255),
  allergies                 varchar(255),
  notes                     varchar(255),
  constraint pk_patient primary key (id))
;

create table ward (
  ward_id                   varchar(255) not null,
  constraint pk_ward primary key (ward_id))
;

create sequence bed_seq;

create sequence doctor_seq;

create sequence patient_seq;

create sequence ward_seq;




# --- !Downs

drop table if exists bed cascade;

drop table if exists doctor cascade;

drop table if exists patient cascade;

drop table if exists ward cascade;

drop sequence if exists bed_seq;

drop sequence if exists doctor_seq;

drop sequence if exists patient_seq;

drop sequence if exists ward_seq;

