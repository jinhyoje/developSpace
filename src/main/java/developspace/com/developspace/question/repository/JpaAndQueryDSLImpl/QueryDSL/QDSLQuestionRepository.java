package developspace.com.developspace.question.repository.JpaAndQueryDSLImpl.QueryDSL;

import com.querydsl.jpa.impl.JPAQueryFactory;
import developspace.com.developspace.question.entity.Question;
import developspace.com.developspace.question.entity.SubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static developspace.com.developspace.question.entity.QQuestion.question;

@Repository
@RequiredArgsConstructor
public class QDSLQuestionRepository {
    private final JPAQueryFactory queryFactory;
    public List<Question> findAllBySubCategory(SubCategory subCategory) {
        return queryFactory
                .selectFrom(question)
                .where(question.subcategory.eq(subCategory))
                .fetch();
    }
}