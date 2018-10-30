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
        private Long id;

        public BaseEntity(Long id) {
            this.id = id;
        }

        public BaseEntity (){}

        public BaseEntity clone(BaseEntity entity){
            BaseEntity base = new BaseEntity();
            base.id = entity.id;

            return base;
        }



    }
