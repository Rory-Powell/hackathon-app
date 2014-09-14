# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bed (
  id                        varchar(255) not null,
  ward_id                   varchar(255),
  is_occupied               boolean,
  constraint pk_bed primary key (id))
;

create table patient (
  id                        varchar(255) not null,
  name                      varchar(255),
  dob                       timestamp,
  address                   varchar(255),
  gp                        varchar(255),
  doctor_id                 varchar(255),
  previous_doctor_id        varchar(255),
  ailment                   varchar(255),
  medication                varchar(255),
  vaccinations              varchar(255),
  allergies                 varchar(255),
  notes                     varchar(255),
  bed_id                    varchar(255),
  constraint pk_patient primary key (id))
;

create table staff (
  id                        varchar(255) not null,
  password                  varchar(255),
  is_doctor                 boolean,
  constraint pk_staff primary key (id))
;

create table ward (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_ward primary key (id))
;

create sequence bed_seq;

create sequence patient_seq;

create sequence staff_seq;

create sequence ward_seq;

alter table bed add constraint fk_bed_ward_1 foreign key (ward_id) references ward (id);
create index ix_bed_ward_1 on bed (ward_id);
alter table patient add constraint fk_patient_doctor_2 foreign key (doctor_id) references staff (id);
create index ix_patient_doctor_2 on patient (doctor_id);
alter table patient add constraint fk_patient_previousDoctor_3 foreign key (previous_doctor_id) references staff (id);
create index ix_patient_previousDoctor_3 on patient (previous_doctor_id);
alter table patient add constraint fk_patient_bed_4 foreign key (bed_id) references bed (id);
create index ix_patient_bed_4 on patient (bed_id);



# --- !Downs

drop table if exists bed cascade;

drop table if exists patient cascade;

drop table if exists staff cascade;

drop table if exists ward cascade;

drop sequence if exists bed_seq;

drop sequence if exists patient_seq;

drop sequence if exists staff_seq;

drop sequence if exists ward_seq;

