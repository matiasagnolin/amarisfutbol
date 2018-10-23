package com.amaris.futbol.domain;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.map.Serializers;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        public BaseEntity(Integer id) {
            this.id = id;
        }
        public BaseEntity (){}

    }
