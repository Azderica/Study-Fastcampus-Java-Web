package com.myepark.study.ifs;

import com.myepark.study.model.network.Header;

public interface CrudInterface<Req, Res> {

    // todo request object 추가
    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);
}
